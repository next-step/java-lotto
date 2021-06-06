package lotto.controllers;

import java.util.Optional;

import lotto.domains.BonusNumber;
import lotto.domains.Ticket;
import lotto.domains.WinningNumbers;
import lotto.enums.Message;
import lotto.views.Display;
import lotto.views.Keyboard;

public final class WinningNumbersController {

    private WinningNumbersController() {
    }

    public static WinningNumbers run() {
        Optional<WinningNumbers> winningNumbers = Optional.empty();

        while (!winningNumbers.isPresent()) {
            winningNumbers = tryAskWinningNumbers();
        }

        return winningNumbers.get();
    }

    private static Optional<WinningNumbers> tryAskWinningNumbers() {
        try {
            Ticket winningTicket = askWinningTicket();
            BonusNumber bonusNumber = askBonusNumber();
            return Optional.of(new WinningNumbers(winningTicket, bonusNumber));
        } catch (Exception e) {
            Display.error(e.getMessage());
            return Optional.empty();
        }
    }

    private static Ticket askWinningTicket() {
        Optional<Ticket> ticket = Optional.empty();

        while (!ticket.isPresent()) {
            ticket = tryAskWinningTicket();
        }

        return ticket.get();
    }

    private static Optional<Ticket> tryAskWinningTicket() {
        try {
            Display.show(Message.WINNING_TICKET);
            return Optional.of(new Ticket(Keyboard.read()));
        } catch (Exception e) {
            Display.error(e.getMessage());
            return Optional.empty();
        }
    }

    private static BonusNumber askBonusNumber() {
        Optional<BonusNumber> bonusNumber = Optional.empty();

        while (!bonusNumber.isPresent()) {
            bonusNumber = tryAskBonusNumber();
        }

        return bonusNumber.get();
    }

    private static Optional<BonusNumber> tryAskBonusNumber() {
        try {
            Display.show(Message.BONUS_NUMBER);
            return Optional.of(new BonusNumber(Keyboard.read()));
        } catch (Exception e) {
            Display.error(e.getMessage());
            return Optional.empty();
        }
    }

}
