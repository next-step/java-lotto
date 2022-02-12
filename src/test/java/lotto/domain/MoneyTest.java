package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @DisplayName("돈_객체_생성시_주입받은_필드_값에_대한_예외_테스트")
    @ParameterizedTest
    @ValueSource(strings = {"900", "-2", "abc"})
    void createMoneyTest(String value) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(value));
    }

    @DisplayName("로또_당첨_수익률_테스트")
    @Test
    void getLottoPrizeRatioTest() {
        Money money = new Money("14000");
        assertThat(
            Math.floor(money.getPrizeRatio(new Money("5000"), new Money("14000")) * 100.0) / 100.0)
            .isEqualTo(0.35);
    }
}
