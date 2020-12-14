package lotto;

import java.util.HashSet;
import java.util.Set;

public class LottoShop {

    private static final String NOT_HAVE_ENOUGH_MONEY_ERROR = "금액은 최소 0이상 이어야 구매 가능합니다.";
    private static final String NOT_DIVIDE_LOTTO_PRICE_ERROR = "지불한 금액이 1000원으로 나누어지지 않습니다.";
    private static final int DEFAULT_LOTTO_PRICE = 1000;
    private static final int ZERO = 0;

    private LottoShop() {
    }

    private static class LottoShopLazyHolder {
        private static final LottoShop instance = new LottoShop();
    }

    public static LottoShop getInstance() {
        return LottoShop.LottoShopLazyHolder.instance;
    }

    public Set<LottoTicket> buyLotto(int money) {
        validatePriceIsEmpty(money);
        validatePriceIsDivide(money);

        int lottoTicketCount = calculateLottoTicketCount(money);
        LottoMachine.getInstance();
        Set<LottoTicket> publishedLottoTickets = publishLottoTicket(lottoTicketCount);

        return publishedLottoTickets;
    }

    private Set<LottoTicket> publishLottoTicket(int lottoTicketCount) {
        Set<LottoTicket> publishedLottoTickets = new HashSet<>();
        for (int i = 0; i < lottoTicketCount; i++) {
            Set<LottoNumber> lottoNumbers = LottoMachine.generateLottoNumber();
            publishedLottoTickets.add(new LottoTicket(lottoNumbers));
        }
        return publishedLottoTickets;
    }

    private int calculateLottoTicketCount(int money) {
        return money / DEFAULT_LOTTO_PRICE;
    }

    private void validatePriceIsEmpty(int price) {
        if(price <= ZERO) {
            throw new IllegalArgumentException(NOT_HAVE_ENOUGH_MONEY_ERROR);
        }
    }

    private void validatePriceIsDivide(int price) {
        if(price % DEFAULT_LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException(NOT_DIVIDE_LOTTO_PRICE_ERROR);
        }
    }
}
