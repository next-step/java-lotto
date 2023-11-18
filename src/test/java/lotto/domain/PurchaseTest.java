package lotto.domain;

import lotto.strategy.FixtureNumberStrategy;
import lotto.strategy.NumberStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseTest {

    private Purchase purchase;

    void createTest(int amount) {
        purchase = new Purchase(amount);
    }

    @Test
    void 로또_구매_갯수() {
        // given
        NumberStrategy numberStrategy = new FixtureNumberStrategy();
        purchase = new Purchase(1000, numberStrategy);
        // when
        int lottoCount = purchase.lottosSize();
        // then
        assertThat(lottoCount).isEqualTo(1);
    }
}
