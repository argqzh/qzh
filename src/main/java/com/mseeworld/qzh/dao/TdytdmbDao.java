/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mseeworld.qzh.dao;

import com.mseeworld.qzh.bean.Tdytdmb;
import java.util.List;

/**
 *
 * @author xy
 */
public interface TdytdmbDao  extends BaseHibernateDao<Tdytdmb>{
  
  public List<Tdytdmb> getAll ();
}
