/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mseeworld.qzh.dao;

import com.mseeworld.qzh.model.Dldjdmb;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author xy
 */
public class DldjdmbDaoImpl  extends BaseHibernateDaoImpl<Dldjdmb> implements DldjdmbDao{
  
  public List<Dldjdmb> getAll() {
    
    Session session = getCurrentSession();
    String sql = "select * from dldjdmb order by dm asc";
    Query q = session.createSQLQuery(sql).addEntity(Dldjdmb.class);

    return q.list();
  }

  public Dldjdmb getByName(String name) {

    Session session = getCurrentSession();
    String sql = "select * from dldjdmb where dldj='" + name.trim() + "'";
    Query q = session.createSQLQuery(sql).addEntity(Dldjdmb.class);

    if (q.list().size() > 0) {
      return (Dldjdmb) q.list().get(0);
    } else {
      return null;
    }
  }
}
