package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("돈_객체_생성시_주입받은_필드_값에_대한_예외_테스트")
    @Test
    void createMoneyTest() {
        Money money = new Money(3);
        assertThat(money.getValue()).isEqualTo(3);
    }

    @DisplayName("로또_당첨_수익률_테스트")
    @Test
    void getLottoPrizeRatioTest() {
        Money money = new Money("14000");
        assertThat(
            Math.floor(money.getPrizeRatio(new Money("5000"), new Money("14000"))*100.0)/100.0)
            .isEqualTo(0.35);
    }
}
