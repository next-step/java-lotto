package step2;

import java.util.List;

public class LottoSeller {
    private static final int MIN_LOTTO_PRICE = 1000;

    public List<LottoTicket> buyLotto(int money) {
        validateMoney(money);
        int lottoCount = money / MIN_LOTTO_PRICE;
        LottoMachine machine = new LottoMachine();

        return machine.extractLottoTicketsByCount(lottoCount);
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
