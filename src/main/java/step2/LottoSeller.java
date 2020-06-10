package step2;

import java.util.List;

public class LottoSeller {
    private static final int DEFAULT_LOTTO_PRICE = 1000;

    public List<LottoTicket> receiveMoney(int money) {
        validateMoney(money);
        int canBuyLottoCount = money / DEFAULT_LOTTO_PRICE;
        LottoStore lottery = new LottoStore();

        return lottery.getLotteryTickets(canBuyLottoCount);
    }

    private void validateMoney(int money) {
        if (money < DEFAULT_LOTTO_PRICE) {
            throw new IllegalArgumentException("1000원이 기본금액입니다.");
        }

        if (money % DEFAULT_LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("거스름돈이 없습니다.");
        }
    }
}
