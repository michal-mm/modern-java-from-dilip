package com.modernjava.payment;

import com.modernjava.domain.Card;
import com.modernjava.domain.PaymentResponse;

public final class CreditCard extends PaymentGateway {

    @Override
    public PaymentResponse makePayment(Card card, double amount) {
        System.out.println("Action payment for CREDIT CARD: " + amount );
        return PaymentResponse.SUCCESS;
    }

}
