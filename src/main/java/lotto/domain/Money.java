package lotto.domain;

import static lotto.domain.LottoMachine.PRICE_OF_LOTTO;

public class Money {

    private long money;

    public Money(long money) {
        if (money < PRICE_OF_LOTTO) {
            throw new IllegalArgumentException("최소 " + PRICE_OF_LOTTO + "원 이상 입력해야 합니다.");
        }

        if (money % PRICE_OF_LOTTO != 0) {
            throw new IllegalArgumentException("로또 구매 금액은 " + PRICE_OF_LOTTO + "원 단위로 입력해야 합니다.");
        }

        this.money = money;
    }

    public int buy(int lottoCount) {
        if (lottoCount < 0) {
            throw new IllegalArgumentException("로또 구매 수량은 0보다 작을 수 없습니다.");
        }
        if (lottoCount * PRICE_OF_LOTTO > this.money) {
            throw new IllegalArgumentException("구매 금액이 부족합니다.");
        }
        this.money -= PRICE_OF_LOTTO * lottoCount;

        return lottoCount;
    }

    public int buyAll() {
        return this.buy( numberOfLottoTickets() );
    }

    public int numberOfLottoTickets() {
        return (int) this.money / PRICE_OF_LOTTO;
    }
}
