/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mseeworld.qzh.dao;

import com.mseeworld.qzh.bean.CbfJtcy;
import java.util.List;

/**
 *
 * @author xy
 */
public interface CbfJtcyDao extends BaseHibernateDao<CbfJtcy> {

  public List<CbfJtcy> getCbfsByCbfBm(String cbfbm);

  public List<CbfJtcy> getFirstNOfAll2(int start, int size, int parentId);
}
