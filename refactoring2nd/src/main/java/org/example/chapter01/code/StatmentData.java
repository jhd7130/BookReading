package org.example.chapter01.code;

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

}
