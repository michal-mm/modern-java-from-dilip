package com.modernjava.payment;

import com.modernjava.domain.Card;
import com.modernjava.domain.PaymentResponse;

public final class RewardsCardPayment extends PaymentGateway {

    @Override
    public PaymentResponse makePayment(Card card, double amount) {
        System.out.println("Action payment for REWARDS CARD: " + amount );
        return PaymentResponse.SUCCESS;
    }

}
