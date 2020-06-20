package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoSeller {
    private static final int MIN_LOTTO_PRICE = 1000;
    private static final Numbers LOTTO_NUMBERS = new Numbers();

    public List<LottoTicket> sellLotto(int money) {
        validateMoney(money);
        int lottoCount = money / MIN_LOTTO_PRICE;

        List<LottoTicket> lottoTickets = new ArrayList<>();
        IntStream.range(0, lottoCount).forEach(i -> lottoTickets.add(new LottoTicket(LOTTO_NUMBERS.extractLottoNumber())));

        return lottoTickets;
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
