package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.exception.InvalidMoneyException;

class MoneyTest {

    @DisplayName("생성자에 음수의 값이 들어오는 경우 예외를 던진다")
    @ParameterizedTest
    @ValueSource(ints = { -100, -1 })
    void constructorTest(int input) {
        assertThatThrownBy(() -> new Money(input)).isInstanceOf(InvalidMoneyException.class);
    }

    @DisplayName("로또 구매 가격이 주어졌을 때 몇 개의 로또를 구매했는지 반환하는 로직 검증")
    @Test
    void lottoCountByAmountTest() {
        int amount = 14_000;
        int expectedCount = 14;
        assertThat(new Money(amount).getLottoCount()).isEqualTo(expectedCount);
    }

    @DisplayName("Money와 Result가 주어졌을 때 해당 결과에 맞는 수익률이 반환되는지 검증")
    @Test
    void ratioTest() {
        Result result = new Result();
        result.add(Rank.FIFTH);

        Money purchasedAmount = new Money(14000);

        assertThat(purchasedAmount.calculateRatio(result.calculateWinningAmount())).isEqualTo(0.35);
    }
}
