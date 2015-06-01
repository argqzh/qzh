package com.mseeworld.qzh.dao;

import com.mseeworld.qzh.bean.AOrganization;
import com.mseeworld.qzh.model.AOrganization2;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class OrganizationDAOImpl extends BaseHibernateDaoImpl<AOrganization> implements OrganizationDAO {

  public List<AOrganization> getOrgByParentId(long id) {

    Session session = getCurrentSession();
    String sql = "select * "
            + "from a_organization "
            + "where is_deleted=false and parent_id= " + id + " "
            + "order by org_id";
    Query q = session.createSQLQuery(sql).addEntity(AOrganization.class);

    return q.list();
  }

  public int getChildNumber(long id) {

    Session session = getCurrentSession();
    String sql = "select count(*) "
            + "from a_organization "
            + "where is_deleted=false and parent_id= " + id;
    Query q = session.createSQLQuery(sql);

    BigInteger otnId = (BigInteger) q.list().get(0);
    return otnId.intValue();
  }

  public void deleteOrgById(String ids) {

    Session session = getCurrentSession();
    String sql = "update a_organization set is_deleted=true  where org_id in(" + ids + ")";
    session.createSQLQuery(sql).executeUpdate();
  }

  public Number count() {

    Session session = getCurrentSession();
    String sql = "select count(*) from a_organization ";
    int tNum = 0;
    Query q = session.createSQLQuery(sql);
    if (!q.list().isEmpty()) {
      BigInteger objId = (BigInteger) q.list().get(0);
      tNum = objId.intValue();
    }
    return tNum;
  }

  public List<AOrganization2> getFirstNOfAll2(int start, int size, int parentId) {

    Session session = getCurrentSession();
    String sql = "select org.*, o.org_name parent_name "
            + "from a_organization org "
            + "left join a_organization o on org.parent_id=o.org_id "
            + "where org.is_deleted=false ";
    if (parentId != 0) {
      sql += " and org.parent_id=" + parentId;
    }
    sql += " order by org.org_id desc";
    Query q = session.createSQLQuery(sql).addEntity(AOrganization2.class);
    q.setFirstResult(start);
    q.setMaxResults(size);
    return q.list();
  }

  @Override
  public void saveByName(AOrganization org) {
    
    String sql = "select * from a_organization where org_name='"+org.getOrgName().trim()+"'";
    Session session = getCurrentSession();
    Query q = session.createSQLQuery(sql).addEntity(AOrganization.class);
    if (q.list().size()>0) {
      AOrganization torg = (AOrganization) q.list().get(0);
      org.setOrgId(torg.getOrgId());
    }else{
      super.save(org);
    }
  }
}
