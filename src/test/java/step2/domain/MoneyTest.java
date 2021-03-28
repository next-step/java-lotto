package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {

    @DisplayName("5천원으로 로또 5개 구입가능, 6개는 구입 불가능 여부 확인한다")
    @ParameterizedTest
    @CsvSource(value = {"5000,5,true", "5000,6,false"})
    void isPossibleBuyLotto(int amount, int purchaseCount, boolean expected) {
        Money money = Money.from(amount);
        assertThat(money.isPossibleBuyLotto(purchaseCount)).isEqualTo(expected);
    }

    @DisplayName("구입금액과 당첨금액에 따른 수익률을 계산한다")
    @ParameterizedTest
    @CsvSource(value = {"5000,5000,1.0", "5000,50000,10.0", "25000,50000,2.0"})
    void getRevenueRate(int amount, int prizeAmount, double expectedRevenueRate) {
        // given
        Money money = Money.from(amount);

        // when
        double revenueRate = money.getRevenueRate(prizeAmount);

        // then
        assertThat(revenueRate).isEqualTo(expectedRevenueRate);
    }
}