package com.mseeworld.qzh.model;
// Generated Aug 20, 2014 8:31:04 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CbjyqzQzzx generated by hbm2java
 */
@Entity
@Table(name="cbjyqz_qzzx"
    ,schema="public"
)
public class CbjyqzQzzx  implements java.io.Serializable {


     private long id;
     private String cbjyqzbm;
     private String zxyy;
     private Date zxrq;

    public CbjyqzQzzx() {
    }

	
    public CbjyqzQzzx(long id) {
        this.id = id;
    }
    public CbjyqzQzzx(long id, String cbjyqzbm, String zxyy, Date zxrq) {
       this.id = id;
       this.cbjyqzbm = cbjyqzbm;
       this.zxyy = zxyy;
       this.zxrq = zxrq;
    }
   
     @Id 
    
    @Column(name="id", unique=true, nullable=false)
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    @Column(name="cbjyqzbm", length=19)
    public String getCbjyqzbm() {
        return this.cbjyqzbm;
    }
    
    public void setCbjyqzbm(String cbjyqzbm) {
        this.cbjyqzbm = cbjyqzbm;
    }
    
    @Column(name="zxyy", length=200)
    public String getZxyy() {
        return this.zxyy;
    }
    
    public void setZxyy(String zxyy) {
        this.zxyy = zxyy;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="zxrq", length=13)
    public Date getZxrq() {
        return this.zxrq;
    }
    
    public void setZxrq(Date zxrq) {
        this.zxrq = zxrq;
    }




}


