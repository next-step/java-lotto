package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private static final int PRICE = 1000;

    private LottoTicket() {
        throw new UnsupportedOperationException("해당 클래스는 인스턴스를 생성할 수 없습니다.");
    }

    public static List<Lotto> issue(final int purchasePrice) {
        int totalLottoCount = getTotalLottoCount(purchasePrice);
        List<Lotto> ticket = new ArrayList<>(totalLottoCount);
        for (int i = 0; i < totalLottoCount; i++) {
            ticket.add(new Lotto());
        }
        return ticket;
    }

    private static int getTotalLottoCount(final int purchasePrice) {
        validatePurchasePrice(purchasePrice);
        return purchasePrice / PRICE;
    }

    private static void validatePurchasePrice(final int purchasePrice) {
        if (purchasePrice % PRICE != 0) {
            throw new IllegalArgumentException("올바른 구매금액이 아닙니다. 로또 개수에 맞게 금액을 넣어주세요.(1장당 1000원)");
        }
    }
}
