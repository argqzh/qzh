package com.mseeworld.qzh.controller;

import com.mseeworld.qzh.dao.DkDao;
import com.mseeworld.qzh.bean.Dk;
import com.mseeworld.qzh.model.Dk2;
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
    String start = request.getParameter("start");
    String psize = request.getParameter("limit");
    String pcbhtId = request.getParameter("cbhtId");

    int ipage = Integer.parseInt(page);
    int istart = Integer.parseInt(start);
    int isize = Integer.parseInt(psize);

    String porgId = request.getParameter("orgId");
    System.out.println("porgId=" + porgId);
    int iorgId = 0;
    if (porgId != null && !porgId.isEmpty()) {
      iorgId = Integer.parseInt(porgId);
    }

    List<Dk2> dks = null;
    int limit1 = 10;

    if (pcbhtId != null && !pcbhtId.isEmpty()) {
      int icbhtId = Integer.parseInt(pcbhtId);
      dks = dkDao.getByCbhtId(istart, isize, icbhtId);
    } else {
      dks = dkDao.getFirstNOfAll2(istart, isize, iorgId);
    }

    int total = dkDao.count().intValue();
    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    StringBuilder rstStr = new StringBuilder("");
    rstStr.append("{totalCount:");
    rstStr.append(total);
    rstStr.append(",rows:[");
    int i = 0;
    for (Dk2 cbf : dks) {
      try {
        String tStr = ow.writeValueAsString(cbf);
        rstStr.append(tStr);
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      if (++i < dks.size()) {
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

    List<Dk> dks = null;
    int limit1 = 10;

    dks = dkDao.getDkOfNullChbtId(limit1);


    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    StringBuilder rstStr = new StringBuilder("");
    rstStr.append("{totalCount:");
    rstStr.append(dks.size());
    rstStr.append(",rows:[");
    int i = 0;
    for (Dk cbf : dks) {
      try {
        String tStr = ow.writeValueAsString(cbf);
        rstStr.append(tStr);
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      if (++i < dks.size()) {
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
