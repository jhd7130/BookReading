package org.example.chapter01.code;

public class Statment {
  public String statement(Invoice invoice, Plays plays) throws Exception {
    StatementData statementData = new StatementData(invoice, plays);
    return renderPlainText(statementData, plays);
  }

  private String renderPlainText(StatementData statementData, Plays plays) throws Exception {
    StringBuilder result = new StringBuilder(String.format("청구내역 (고객명: %s)\n", statementData.customerName()));
    for (Performance performance : statementData.getPerformances()) {
      result.append(String.format("%s: $%d %d석\n", statementData.playFor(performance).getName(), statementData.amountFor(performance) / 100, performance.getAudience()));
    }

    result.append(String.format("총액: $%d\n", statementData.totalAmount() / 100));
    result.append(String.format("적립 포인트: %d점", statementData.totalVolumeCredits()));
    return result.toString();
  }

  private String renderHtml(StatementData statementData) throws Exception {
    StringBuilder result = new StringBuilder(String.format("<h1> 청구내역 (고객명: %s)\n </h1>", statementData.customerName()));
    result.append("<table> \n");
    result.append("<tr><th> 연극 </th> <th>좌석 수</th> <th>금액</th>");
    for (Performance performance : statementData.getPerformances()) {
      result.append(String.format("<tr><td> %s: </td> <td> $%d </td> <td> %d석 </td></tr>\n",statementData.playFor(performance).getName(), statementData.amountFor(performance) / 100, performance.getAudience()));
    }
    result.append("</table>\n");

    result.append(String.format("총액: $%d\n", statementData.totalAmount()));
    result.append(String.format("적립 포인트: %d점", statementData.totalVolumeCredits()));
    return result.toString();
  }
}
