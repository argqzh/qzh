package com.mseeworld.qzh.controller;

import com.mseeworld.qzh.dao.FbfDao;
import com.mseeworld.qzh.bean.Fbf;
import com.mseeworld.qzh.service.PeopleService;
import com.mseeworld.qzh.util.NumberFormatUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/fbf")
public class FbfController {

  private PeopleService peopleService;
  private FbfDao fbfDao;

  /**
   * @param fbfDao the fbfDao to set
   */
  @Resource
  public void setFbfDao(FbfDao fbfDao) {
    this.fbfDao = fbfDao;
  }

  @Resource
  public void setPeopleService(PeopleService peopleService) {
    this.peopleService = peopleService;
  }

  /**
   * 分页查询信息./people/list_people.do
   */
  @RequestMapping(value = "/listall_fbf", method = RequestMethod.GET)
  public void listAllPeople(HttpServletRequest request, PrintWriter writer) {

    String page = request.getParameter("page");
    String start = request.getParameter("start");
    String psize = request.getParameter("limit");
    int ipage = Integer.parseInt(page);
    int istart = Integer.parseInt(start);
    int isize = Integer.parseInt(psize);
    
    String porgId = request.getParameter("orgId");
    System.out.println("porgId="+porgId);
    int iorgId = 0;
    if(porgId!=null && !porgId.isEmpty()){
      iorgId = Integer.parseInt(porgId);
    }
    
    int total = fbfDao.count().intValue();
    List<Fbf> fbfs = fbfDao.getFirstNOfAll2(istart, isize, iorgId);

    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    StringBuilder rstStr = new StringBuilder("");
    rstStr.append("{totalCount:");
    rstStr.append(total);
    rstStr.append(",rows:[");
    int i = 0;
    for (Fbf fbf : fbfs) {
      try {
        String tStr = ow.writeValueAsString(fbf);
        rstStr.append(tStr);
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      if (++i < fbfs.size()) {
        rstStr.append(",");
      }
    }
    rstStr.append("]}");
    writer.write(rstStr.toString());
  }

  /**
   * 新增people/add_people.do
   */
  @RequestMapping(value = "/add_fbf", method = RequestMethod.POST)
  public void addPeople(@ModelAttribute("fbf") Fbf obj, HttpServletResponse response, PrintWriter writer) throws IOException {

    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    String tStr = ow.writeValueAsString(obj);
    System.out.println(tStr);
    
    fbfDao.saveOrUpdate(obj);
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;  charset=UTF-8");

    writer.write("{success:true, msg:'发包方信息保存成功!'}");
  }

  /**
   * 删除
   */
  @RequestMapping(value = "/remove_fbf", method = RequestMethod.POST)
  public void delete(HttpServletRequest request, PrintWriter writer) {

//		String[] ids = request.getParameter("ids").replaceAll("\"", "").split(",");
    String ids = request.getParameter("ids");
    fbfDao.deleteByIds(ids);
    writer.write("{success:true,msg:'删除成功!'}");
  }

  /**
   * 修改信息people/update_people.do
   */
  @RequestMapping(value = "/update_fbf", method = RequestMethod.POST)
  public void updatePeople(@RequestParam MultipartFile photos, HttpServletRequest request, HttpServletResponse response, PrintWriter writer) throws IOException {

  }

  @InitBinder
  public void initBinder(WebDataBinder binder) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    NumberFormatUtil.registerDoubleFormat(binder);
  }
}
