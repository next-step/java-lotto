package lotto.domain;

import lotto.exception.IllegalPurchaseAmountException;

import java.util.List;

public class LottoTicketMachine {

    public static final int AMOUNT_PER_TICKET = 1000;

    public static IssuedLottoTickets issue(int amount, List<List<Integer>> manualLottoNumbers) {
        validatePurchaseAmount(amount);

        int manualCount = manualLottoNumbers.size();
        int autoAmount = amount - manualCount * AMOUNT_PER_TICKET;
        int autoCount = autoAmount / AMOUNT_PER_TICKET;

        return new IssuedLottoTickets(LottoTickets.auto(autoCount), LottoTickets.manual(manualLottoNumbers));
    }

    private static void validatePurchaseAmount(int amount) {
        if (amount < AMOUNT_PER_TICKET) {
            throw new IllegalPurchaseAmountException(AMOUNT_PER_TICKET, amount);
        }
    }

}
