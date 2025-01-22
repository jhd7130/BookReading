package org.example.chapter01.code;

import java.util.List;

public class StatementData {
    private final Invoice invoice;
    private final Plays plays;

    public StatementData(Invoice invoice, Plays plays) {
        this.invoice = invoice;
        this.plays = plays;
    }

    public String customerName() {
        return invoice.getCustomer();
    }

    public List<Performance> getPerformances() {
        return invoice.getPerformances();
    }


    public Invoice getInvoice() {
        return this.invoice;
    }

    public Play playFor(Performance performance) {
        return plays.get(performance);
    }

    public Integer totalAmount() throws Exception {
        int totalAmount = 0;
        for (Performance performance : invoice.getPerformances()) {
            totalAmount += this.amountFor(performance);
        }
        return totalAmount;
    }

    public Integer totalVolumeCredits() {
        int volumeCredit = 0;
        for (Performance performance : invoice.getPerformances()) {
            volumeCredit = volumeCreditFor(performance);
        }
        return volumeCredit;
    }

    private int volumeCreditFor(Performance performance) {
        int result = 0;
        // 포인트를 적립한다.
        result += Math.max(performance.getAudience() - 30, 0);

        // 희극 관객 5명마다 추가 포인트를 제공핟나.
        if (this.playFor(performance).getType().equals(PlayType.COMEDY)) {
            result += Math.floor(performance.getAudience() / 5);
        }
        return result;
    }

    public Integer amountFor(Performance performance) throws Exception {
        int result = 0;
        switch (this.playFor(performance).getType()) {
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
