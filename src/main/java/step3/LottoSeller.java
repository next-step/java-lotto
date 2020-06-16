package step3;

import java.util.List;

public class LottoSeller {
    private static final int MIN_LOTTO_PRICE = 1000;
    private static final LottoNumbers LOTTO_NUMBERS = new LottoNumbers();

    public List<LottoTicket> sellLotto(int money) {
        validateMoney(money);
        int lottoCount = money / MIN_LOTTO_PRICE;

        return LOTTO_NUMBERS.extractLottoTicketsByCount(lottoCount);
    }

    private void validateMoney(int money) {
        if (money < MIN_LOTTO_PRICE) {
            throw new IllegalArgumentException("1000원이 최소 구매 금액입니다.");
        }

        if (money % MIN_LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("거스름돈이 없습니다.");
        }
    }
}
