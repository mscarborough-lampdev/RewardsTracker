package com.mikescarborough.demos.RewardsTracker.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * A class representing a data entity that
 * tracks a summary of one transaction
 *
 * @author  Mike Scarborough
 * @version 1.0
 * @since 2020-04-07
 */
@Entity
public class TransactionSummary {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private Integer custId;

  // @Temporal(TemporalType.TIMESTAMP)
  private java.util.Date timestampUtc;

  private Float overallTotal;

  private Integer numItems;

  /**
   * Returns the id of the transaction summary.
   *
   * @return    the id.
   */  
  public Integer getId() {
    return id;
  }



  /**
   * Edits the id of the transaction summary.
   *
   * @param     id  the new id.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Returns the customer id for the transaction summary.
   *
   * @return    the customer id.
   */  
  public Integer getCustId() {
    return custId;
  }

  /**
   * Edits the customer id of the transaction summary.
   *
   * @param     custId  an Integer with the new customer id.
   */
  public void setCustId(Integer custId) {
    this.custId = custId;
  }

  /**
   * Returns the timestamp for the transaction summary in UTC.
   *
   * @return    the timestamp.
   */  
  public Date getTimestampUtc() {
    return timestampUtc;
  }

  /**
   * Edits the timestamp of the transaction summary.
   *
   * @param     timestamp  a Date with the new timestamp.
   */
  public void setTimestamp(Date timestamp) {
    this.timestampUtc = timestamp;
  }

  /**
   * Returns the sales total for the transaction summary
   * in US Dollars and cents.
   *
   * @return    the order total.
   */  
  public Float getOverallTotal() {
    return overallTotal;
  }

  /**
   * Edits the sales total of the transaction summary.
   *
   * @param     overallTotal  a Float for the new sales total.
   */
  public void setOverallTotal(Float overallTotal) {
    this.overallTotal = overallTotal;
  }

  /**
   * Returns the number of items sold in the transaction summary.
   *
   * @return    the number of items.
   */  
  public Integer getNumItems() {
    return numItems;
  }

  /**
   * Edits the number of items of the transaction summary.
   *
   * @param     numItems  an Integer for the new number of items.
   */
  public void setNumItems(Integer numItems) {
    this.custId = numItems;
  }
}