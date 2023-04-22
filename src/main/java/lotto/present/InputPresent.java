package lotto.present;

import lotto.domain.Ticket;

public class InputPresent {
    private static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요";
    private static final String PURCHASE_CONFIRM = "%s개를 구매했습니다";
    private static final String WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요";
    public InputPresent() {
    }

    public int purchaseCount() {
        throw new RuntimeException();
    }

    public Ticket winningNumber() {
        return null;
    }
}
