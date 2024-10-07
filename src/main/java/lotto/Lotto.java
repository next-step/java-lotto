package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int LOTTO_TICKET_PRICE = 1000;

    private Lotto() {
        throw new UnsupportedOperationException("해당 클래스는 인스턴스를 생성할 수 없습니다.");
    }

    public static List<List<Integer>> issueTickets(final int totalPurchasePrice) {
        validatePurchasePrice(totalPurchasePrice);
        return Collections.emptyList();
    }

    private static void validatePurchasePrice(int totalPurchasePrice) {
        if (totalPurchasePrice % LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException("올바른 구매금액이 아닙니다. 로또 개수에 맞게 금액을 넣어주세요.(1장당 1000원)");
        }
    }
}
