package lotto.domain;

import lotto.exception.MinimumPurchaseAmountException;
import lotto.util.LottoTicketUtils;

public class LottoMachine {
    private static final String PURCHASE_MESSAGE = "%d개를 구매하셨습니다.";

    public static LottoResult winningResult(LottoWinningTicket lottoWinningTicket, LottoTickets lottoTickets) {
        LottoResult result = new LottoResult();
        LottoPrize lottoPrize;

        for (LottoTicket ticket : lottoTickets.ticketList()) {
            lottoPrize = LottoPrize.find(ticket.findMatchCount(lottoWinningTicket));
            result.increase(lottoPrize);
        }
        return result;
    }

    public LottoTickets purchaseTicket(String purchaseAmount) {
        int ticketCount = parseToInt(purchaseAmount) / LottoTicketUtils.TICKET_PRICE;
        System.out.println(String.format(PURCHASE_MESSAGE, ticketCount));
        return new LottoTickets(ticketCount);
    }

    private static void negativeNumberValidator(int purchaseAmount) {
        if (purchaseAmount < LottoTicketUtils.TICKET_PRICE) {
            throw new MinimumPurchaseAmountException();
        }
    }
    private static int parseToInt(String input) {
        int purchaseAmount = 0;
        try {
            purchaseAmount = Integer.parseInt(input);
            negativeNumberValidator(purchaseAmount);
        } catch (RuntimeException e) {
            throw new RuntimeException("" + e.getMessage());
        }
        return purchaseAmount;
    }

}
