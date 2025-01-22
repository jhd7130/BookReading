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
}
