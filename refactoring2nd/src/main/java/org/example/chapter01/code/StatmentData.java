package org.example.chapter01.code;

import java.util.List;

public class StatmentData {
    private final Invoice invoice;
    private final Plays plays;

    public StatmentData(Invoice invoice, Plays plays) {
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
