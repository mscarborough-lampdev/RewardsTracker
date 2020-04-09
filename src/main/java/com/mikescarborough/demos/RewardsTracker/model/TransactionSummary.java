package com.mikescarborough.demos.RewardsTracker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Date;

@Entity
public class TransactionSummary {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private Integer custId;

  @Temporal(TemporalType.TIMESTAMP)
  private Date timestamp;

  private Float overallTotal;

  private Integer numItems;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getCustId() {
    return custId;
  }

  public void setCustId(Integer custId) {
    this.custId = custId;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public Float getOverallTotal() {
    return overallTotal;
  }

  public void setOverallTotal(Float overallTotal) {
    this.overallTotal = overallTotal;
  }

  public Integer getNumItems() {
    return numItems;
  }

  public void setNumItems(Integer numItems) {
    this.custId = numItems;
  }
}