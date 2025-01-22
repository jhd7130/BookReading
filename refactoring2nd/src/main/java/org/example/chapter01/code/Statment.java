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

    result.append(String.format("총액: $%d\n", totalAmount(statmentData.getInvoice(), plays) / 100));
    result.append(String.format("적립 포인트: %d점", totalVolumeCreditFor(statmentData.getInvoice(), plays)));
    return result.toString();
  }

  private int totalAmount(Invoice invoice, Plays plays) throws Exception {
    int totalAmount = 0;
    for (Performance performance : invoice.getPerformances()) {
      totalAmount += amountFor(performance, plays);
    }
    return totalAmount;
  }

  private int totalVolumeCreditFor(Invoice invoice, Plays plays) {
    int volumeCredit = 0;
    for (Performance performance : invoice.getPerformances()) {
      volumeCredit = totalVolumeCreditFor(plays, performance);
    }
    return volumeCredit;
  }


  private int totalVolumeCreditFor(Plays plays, Performance performance) {
    int result = 0;
    // 포인트를 적립한다.
    result += Math.max(performance.getAudience() - 30, 0);

    // 희극 관객 5명마다 추가 포인트를 제공핟나.
    if (playFor(plays, performance).getType().equals(PlayType.COMEDY)) {
      result += Math.floor(performance.getAudience() / 5);
    }
    return result;
  }

  private Play playFor(Plays plays, Performance performance) {
    return plays.get(performance);
  }

  private int amountFor(Performance performance, Plays plays) throws Exception {
    int result = 0;
    switch (playFor(plays, performance).getType()) {
      case TRAGEDY:
        result = 40000;
        if (performance.getAudience() > 30) {
          result += 1000 * (performance.getAudience() - 30);
        }
        break;
      case COMEDY:
        result = 30000;
        if (performance.getAudience() > 20) {
          result += 10000 + 500 * (performance.getAudience() - 20);
        }
        result += 300 * performance.getAudience();
        break;
      default:
        throw new Exception("알 수 없는 장르");
    }
    return result;
  }
}
