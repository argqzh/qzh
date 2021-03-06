package com.mseeworld.qzh.controller;

import com.mseeworld.qzh.dao.DkDao;
import com.mseeworld.qzh.model.Dk;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/dk")
public class DkController {

  private DkDao dkDao;

  /**
   * @param cbfDao the cbfDao to set
   */
  @Resource
  public void setDkDao(DkDao dkDao) {
    this.dkDao = dkDao;
  }

  @RequestMapping(value = "/list_dk", method = RequestMethod.GET)
  public void listAll(HttpServletRequest request, PrintWriter writer) {

    String page = request.getParameter("page");
    String start = request.getParameter("from");
    String limit = request.getParameter("to");

    String orgId = request.getParameter("orgId");
    String cbhtId = request.getParameter("cbhtId");

    List<Dk> cbfs = null;
    int limit1 = 10;

    if (orgId != null && !orgId.trim().isEmpty()) {
      if (!orgId.equals("all") && !orgId.equals("0")) {
        cbfs = dkDao.getByOrgId(Integer.parseInt(orgId), limit1);
      }
    } else if (cbhtId != null && !cbhtId.trim().isEmpty() && !cbhtId.equals("0")) {
      cbfs = dkDao.getByCbhtId(Integer.parseInt(cbhtId), limit1);
    } else {
      cbfs = dkDao.getFirstNOfAll(limit1);
    }

    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    StringBuilder rstStr = new StringBuilder("");
    rstStr.append("{totalCount:");
    rstStr.append(cbfs.size());
    rstStr.append(",rows:[");
    int i = 0;
    for (Dk cbf : cbfs) {
      try {
        String tStr = ow.writeValueAsString(cbf);
        rstStr.append(tStr);
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      if (++i < cbfs.size()) {
        rstStr.append(",");
      }
    }
    rstStr.append("]}");
    writer.write(rstStr.toString());
  }

  @RequestMapping(value = "/list_dk_cbht", method = RequestMethod.GET)
  public void listDkCbht(HttpServletRequest request, PrintWriter writer) {

    String page = request.getParameter("page");
    String start = request.getParameter("from");
    String limit = request.getParameter("to");

    String orgId = request.getParameter("orgId");
    String cbhtId = request.getParameter("cbhtId");

    List<Dk> cbfs = null;
    int limit1 = 10;

    cbfs = dkDao.getDkOfNullChbtId(limit1);


    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    StringBuilder rstStr = new StringBuilder("");
    rstStr.append("{totalCount:");
    rstStr.append(cbfs.size());
    rstStr.append(",rows:[");
    int i = 0;
    for (Dk cbf : cbfs) {
      try {
        String tStr = ow.writeValueAsString(cbf);
        rstStr.append(tStr);
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      if (++i < cbfs.size()) {
        rstStr.append(",");
      }
    }
    rstStr.append("]}");
    writer.write(rstStr.toString());
  }

  @RequestMapping(value = "/add_dk", method = RequestMethod.POST)
  public void add(@ModelAttribute("dk") Dk obj, Map model, HttpServletResponse response, PrintWriter writer) {

    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;  charset=UTF-8");

    try {
//      Dk aa = new Dk();
      ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
      String tStr = ow.writeValueAsString(obj);
//      System.out.println(tStr);
      dkDao.saveOrUpdate(obj);

      writer.write("{success:true, msg:'地块信息保存成功!'}");
    } catch (IOException ex) {
      writer.write("{success:false, msg:'地块信息保存失败!'}");
      Logger.getLogger(DkController.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @RequestMapping(value = "/update_dk", method = RequestMethod.GET)
  public void update(HttpServletRequest request, PrintWriter writer) {

    String dkIds = request.getParameter("dkIds");
    String cbhtId = request.getParameter("cbhtId");
    System.out.println("dkIds=" + dkIds);
    System.out.println("cbhtId=" + cbhtId);

    dkDao.updateCbhtId(dkIds, cbhtId);


    writer.write("{success:true, msg:'地块信息保存成功!'}");
  }
  
  @RequestMapping(value = "/update_dk_cbht", method = RequestMethod.POST)
  public void update2(HttpServletRequest request, PrintWriter writer) {

    String ids = request.getParameter("ids");
    dkDao.deleteCbhtByIds(ids);
    writer.write("{success:true,msg:'删除成功!'}");
  }

  /**
   * 删除
   */
  @RequestMapping(value = "/remove_dk", method = RequestMethod.POST)
  public void delete(HttpServletRequest request, PrintWriter writer) {

    String ids = request.getParameter("ids");
    dkDao.deleteByIds(ids);
    writer.write("{success:true,msg:'删除成功!'}");
  }
}
