package com.mseeworld.qzh.model;
// Generated Sep 6, 2014 9:23:12 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CbjyqzQzbf generated by hbm2java
 */
@Entity
@Table(name="cbjyqz_qzbf"
    ,schema="public"
)
public class CbjyqzQzbf  implements java.io.Serializable {


     private long id;
     private String cbjyqzbm;
     private String qzbfyy;
     private Date bfrq;
     private Date qzbflqrq;
     private String qzbflqrxm;
     private Character bflqrzjlx;
     private String bflqrzjhm;

    public CbjyqzQzbf() {
    }

	
    public CbjyqzQzbf(long id) {
        this.id = id;
    }
    public CbjyqzQzbf(long id, String cbjyqzbm, String qzbfyy, Date bfrq, Date qzbflqrq, String qzbflqrxm, Character bflqrzjlx, String bflqrzjhm) {
       this.id = id;
       this.cbjyqzbm = cbjyqzbm;
       this.qzbfyy = qzbfyy;
       this.bfrq = bfrq;
       this.qzbflqrq = qzbflqrq;
       this.qzbflqrxm = qzbflqrxm;
       this.bflqrzjlx = bflqrzjlx;
       this.bflqrzjhm = bflqrzjhm;
    }
   

     @Id 
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cbjyqz_qzbf_seq")
  @SequenceGenerator(name = "cbjyqz_qzbf_seq", sequenceName = "cbjyqz_qzbf_id_seq",allocationSize=1)
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
    
    @Column(name="qzbfyy", length=200)
    public String getQzbfyy() {
        return this.qzbfyy;
    }
    
    public void setQzbfyy(String qzbfyy) {
        this.qzbfyy = qzbfyy;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="bfrq", length=13)
    public Date getBfrq() {
        return this.bfrq;
    }
    
    public void setBfrq(Date bfrq) {
        this.bfrq = bfrq;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="qzbflqrq", length=13)
    public Date getQzbflqrq() {
        return this.qzbflqrq;
    }
    
    public void setQzbflqrq(Date qzbflqrq) {
        this.qzbflqrq = qzbflqrq;
    }
    
    @Column(name="qzbflqrxm", length=10)
    public String getQzbflqrxm() {
        return this.qzbflqrxm;
    }
    
    public void setQzbflqrxm(String qzbflqrxm) {
        this.qzbflqrxm = qzbflqrxm;
    }
    
    @Column(name="bflqrzjlx", length=1)
    public Character getBflqrzjlx() {
        return this.bflqrzjlx;
    }
    
    public void setBflqrzjlx(Character bflqrzjlx) {
        this.bflqrzjlx = bflqrzjlx;
    }
    
    @Column(name="bflqrzjhm", length=20)
    public String getBflqrzjhm() {
        return this.bflqrzjhm;
    }
    
    public void setBflqrzjhm(String bflqrzjhm) {
        this.bflqrzjhm = bflqrzjhm;
    }




}


