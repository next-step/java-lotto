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

    @DisplayName("Money와 Result가 주어졌을 때 해당 결과에 맞는 수익률이 반환되는지 검증")
    @Test
    void ratioTest() {
        Result result = new Result();
        result.add(Rank.FIFTH);

        Money purchasedAmount = new Money(14_000);

        assertThat(purchasedAmount.calculateRatio(result.calculateWinningAmount())).isEqualTo(0.35);
    }

    @DisplayName("Money가 주어졌을 때 구매할 수 있는 로또 개수를 반환하는지 검증")
    @Test
    void countTest() {
        assertThat(new Money(14_000).countToBuyLotto()).isEqualTo(14);
    }

    @DisplayName("Money와 수동으로 구매한 로또 개수가 주어졌을 때 거스름돈을 반환하는지 검증")
    @Test
    void byLottoTest() {
        assertThat(new Money(14_000).buyLotto(3)).isEqualTo(new Money(11_000));
    }
}
