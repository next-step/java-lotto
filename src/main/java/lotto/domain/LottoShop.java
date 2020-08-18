package lotto.domain;

import java.util.Set;

public class LottoShop {
    private static final int DEFAULT_PRICE_UNIT = 1000;
    private static final String PRICE_EMPTY_ERROR = "금액은 최소 0이상 이어야 구매 가능합니다.";
    private static final String PRICE_DIVIDE_ERROR = "지불한 금액이 1000원으로 나누어지지 않습니다.";

    public static Set<LottoTicket> buyLotto(int price) {
        validatePriceIsEmpty(price);
        validatePriceIsDivide(price);

        int lottoTicketCount = price / DEFAULT_PRICE_UNIT;
        LottoMachine.getInstance();
        PublishedLottoTicket publishedLottoTicket = new PublishedLottoTicket(lottoTicketCount);
        return publishedLottoTicket.getPublishedLottoTicket();
    }


    private static void validatePriceIsEmpty(int price) {
        if(price <= 0) {
            throw new IllegalArgumentException(PRICE_EMPTY_ERROR);
        }
    }

    private static void validatePriceIsDivide(int price) {
        if(price % DEFAULT_PRICE_UNIT != 0) {
            throw new IllegalArgumentException(PRICE_DIVIDE_ERROR);
        }
    }
}
