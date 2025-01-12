package org.example.chapter01.code;

import java.util.List;

public class Invoice {
  private String customer;
  private List<Performance> performances;

  public String getCustomer() {
    return this.customer;
  }

  public List<Performance> getPerformances() {
    return this.performances;
  }

  @Override
  public String toString() {
    return "Invoice{" +
        "customer='" + customer + '\'' +
        ", performances=" + performances +
        '}';
  }
}
