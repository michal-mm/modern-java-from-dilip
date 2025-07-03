package com.modernjava.payment;

import com.modernjava.domain.Card;
import com.modernjava.domain.PaymentResponse;

public sealed abstract class PaymentGateway permits DebitCardPayment, RewardsCard, CreditCard {

    public abstract PaymentResponse makePayment (Card card, double amount);
}
