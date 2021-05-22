package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private final String ERROR_AMOUNT_CANNOT_BE_DIVIDED = "로또 가격으로 정확히 나누어떨어지는 금액을 입력해주세요.";
    private final String ERROR_AMOUNT_OUT_OF_RANGE = "1천원 이상, 10만원 이하의 금액을 입력해주세요.";
    private final String TOTAL_COUNT_FORMAT = "%d개를 구매했습니다.%n";

    private final int PRICE_PER_TICKET = 1000;
    private final int MINIMUM_PURCHASE_AMOUNT = 1000;
    private final int MAXIMUM_PURCHASE_AMOUNT = 100000;

    private int purchaseAmount;
    private final List<LottoTicket> lottoTickets;
    private LottoResult lottoResult;

    public LottoTickets(int amount) throws IllegalArgumentException {
        checkValidInput(amount);
        checkDividable(amount);
        lottoResult = new LottoResult(amount);
        this.purchaseAmount = amount;
        this.lottoTickets = issueTickets(purchaseAmount / PRICE_PER_TICKET);
    }

    private List<LottoTicket> issueTickets(int count) {
        List<LottoTicket> ticketList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            LottoTicket ticket = LottoTicketGenerator.start().extract();
            ticketList.add(ticket);
        }
        return ticketList;
    }

    public LottoResult matchingResultWith(WinningNumbers winningNumbers) {
        for (LottoTicket ticket : lottoTickets) {
            MatchStatus status = ticket.matchingStatusWith(winningNumbers);
            lottoResult.updateValue(status);
        }
        return lottoResult;
    }

    private void checkValidInput(int amount) throws IllegalArgumentException {
        if (amount < MINIMUM_PURCHASE_AMOUNT
                || amount > MAXIMUM_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(ERROR_AMOUNT_OUT_OF_RANGE);
        }
    }

    private void checkDividable(int amount) throws IllegalArgumentException {
        if (amount % PRICE_PER_TICKET != 0) {
            throw new IllegalArgumentException(ERROR_AMOUNT_CANNOT_BE_DIVIDED);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(TOTAL_COUNT_FORMAT, lottoTickets.size()));
        for (LottoTicket ticket : lottoTickets) {
            stringBuilder.append(ticket.toString());
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
