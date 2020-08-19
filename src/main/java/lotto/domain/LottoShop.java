package lotto.domain;

public class LottoShop {
    private static final int DEFAULT_LOTTO_PRICE = 1000;

    private LottoShop() {
    }

    public static PublishedLottoTicket buyLotto(int money) {
        validatePriceIsEmpty(money);
        validatePriceIsDivide(money);

        LottoTicketCount lottoTicketCount = new LottoTicketCount(money);
        LottoMachine.getInstance();
        PublishedLottoTicket publishedLottoTicket = new PublishedLottoTicket(lottoTicketCount.getLottoTicketCount());

        return publishedLottoTicket;
    }


    private static void validatePriceIsEmpty(int price) {
        if(price <= 0) {
            throw new IllegalArgumentException("금액은 최소 0이상 이어야 구매 가능합니다.");
        }
    }

    private static void validatePriceIsDivide(int price) {
        if(price % DEFAULT_LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("지불한 금액이 1000원으로 나누어지지 않습니다.");
        }
    }
}
