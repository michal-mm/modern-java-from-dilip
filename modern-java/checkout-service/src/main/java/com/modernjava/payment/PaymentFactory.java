package com.modernjava.payment;

import com.modernjava.domain.CardType;

public class PaymentFactory {

    public static PaymentGateway paymentGateway (CardType cardType) {

        return switch (cardType) {
            case DEBIT -> new DebitCardPayment();
            case REWARDS -> new RewardsCardPayment();
            case CREDIT -> new CreditCardPayment();
            case null -> throw new IllegalArgumentException("CardType can't be null");
        };
    }
}
