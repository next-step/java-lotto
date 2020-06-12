package lotto.domain.data;

import lotto.domain.data.PriceLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PriceLottoTest {

    @DisplayName("입력한 금액 만큼의 Price가 만들어진다.")
    @Test
    public void createPriceTest() {
        PriceLotto priceLotto = PriceLotto.of(10_000);

        assertThat(priceLotto.getIntValue()).isEqualTo(10_000);
    }

    @DisplayName("음수가 입력될 경우 IllegalArgument 예외가 발생한다.")
    @Test
    public void createPriceNegativeTest() {
        assertThatThrownBy(() -> {
            PriceLotto priceLotto = PriceLotto.of(-10_000);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매한 로또수와 로또하나당 금액을 입력하면 금액이 빠져 나간다.")
    @Test
    public void balanceAfterBuyLottoTest() {
        PriceLotto priceLotto = PriceLotto.of(10_000);
        priceLotto.boughtLotto(1000,5, 1);

        assertThat(priceLotto.getIntValue()).isEqualTo(4_000);
    }

    @DisplayName("구매한 로또수의 금액이 잔액보다 크면 IllegalArgumetException 을 발생한다.")
    @Test
    public void balanceOvwrBuyLottoTest() {
        PriceLotto priceLotto = PriceLotto.of(10_000);

        assertThatThrownBy(() -> {
            priceLotto.boughtLotto(1000,5, 6);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
