package lotto.controllers;

import java.util.Optional;

import lotto.domains.Purchase;
import lotto.enums.Message;
import lotto.tool.Converter;
import lotto.views.Display;
import lotto.views.Keyboard;

public final class PurchaseController {

    private PurchaseController() {
    }

    public static Purchase run() {
        Purchase purchase = buyTickets();

        Display.show(Message.TICKET_AMOUNT, purchase.ticketsAmount());

        purchase.selectManualAmount(askAmount());

        return purchase;
    }

    private static Purchase buyTickets() {
        Optional<Purchase> purchase = Optional.empty();

        while (!purchase.isPresent()) {
            purchase = tryBuyTickets();
        }

        return purchase.get();
    }

    private static Optional<Purchase> tryBuyTickets() {
        try {
            Display.show(Message.PURCHASE);
            return Optional.of(new Purchase(Keyboard.read()));
        } catch (Exception e) {
            Display.error(e.getMessage());
            return Optional.empty();
        }
    }

    private static int askAmount() {
        Optional<Integer> number = Optional.empty();

        while (!number.isPresent()) {
            number = tryAskAmount();
        }

        return number.get();
    }

    private static Optional<Integer> tryAskAmount() {
        try {
            Display.show(Message.MANUAL_AMOUNT);
            return Optional.of(Converter.toInteger(Keyboard.read()));
        } catch (Exception e) {
            Display.error(e.getMessage());
            return Optional.empty();
        }
    }

}
