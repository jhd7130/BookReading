package org.example.chapter01.code;

public class Statment {
  public String statement(Invoice invoice, Plays plays) throws Exception {
    StatmentData statmentData = new StatmentData(invoice, plays);
    return renderPlainText(statmentData, plays);
  }

  private String renderPlainText(StatmentData statmentData, Plays plays) throws Exception {
    StringBuilder result = new StringBuilder(String.format("청구내역 (고객명: %s)\n", statmentData.customerName()));
    for (Performance performance : statmentData.getPerformances()) {
      result.append(String.format("%s: $%d %d석\n",statmentData.playFor(performance).getName(), statmentData.amountFor(performance) / 100, performance.getAudience()));
    }

    result.append(String.format("총액: $%d\n", statmentData.totalAmount() / 100));
    result.append(String.format("적립 포인트: %d점", statmentData.totalVolumeCreditFor()));
    return result.toString();
  }
}
