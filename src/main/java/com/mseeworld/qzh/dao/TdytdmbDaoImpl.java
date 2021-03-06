/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mseeworld.qzh.dao;

import com.mseeworld.qzh.model.Tdytdmb;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author xy
 */
public class TdytdmbDaoImpl  extends BaseHibernateDaoImpl<Tdytdmb> implements TdytdmbDao{
  
  public List<Tdytdmb> getAll() {
    
    Session session = getCurrentSession();
    String sql = "select * from tdytdmb order by dm asc";
    Query q = session.createSQLQuery(sql).addEntity(Tdytdmb.class);

    return q.list();
  }

  public Tdytdmb getByName(String name) {

    Session session = getCurrentSession();
    String sql = "select * from tdytdmb where tdytd='" + name.trim() + "'";
    Query q = session.createSQLQuery(sql).addEntity(Tdytdmb.class);

    if (q.list().size() > 0) {
      return (Tdytdmb) q.list().get(0);
    } else {
      return null;
    }
  }
}
