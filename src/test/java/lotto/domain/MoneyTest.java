package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @Test
    public void 로또구매시_1000원_미만은_에러() {
        LottoMachine machine = new LottoMachine();

        int money = 500;
        assertThatThrownBy(() -> machine.buy(new Money(money)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 로또구매시_1000원_미만의_잔돈은_허용하지_않음() {
        LottoMachine machine = new LottoMachine();

        int money = 1500;
        assertThatThrownBy(() -> machine.buy(new Money(money)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}