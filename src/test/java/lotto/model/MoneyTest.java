package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @DisplayName("돈을 생성하는데 성공한다")
    @Test
    void createMoney() {
        assertThat(Money.won(1000)).isEqualTo(Money.won(1000));
    }

    @DisplayName("돈이 음수일 경우 exception")
    @Test
    void noNaturalMoneyThenFail() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Money.won(-1));
    }

    @DisplayName("로또 구입한 총 금액")
    @Test
    void calculateTotalByBuyLotto() {
        int count = 5;

        Money result = Lotto.PRICE.times(count);

        assertThat(result).isEqualTo(Money.won(5000));
    }

    @DisplayName("로또 구매한 값 지불한 나머지 금액")
    @Test
    void spendOnLotto() {
        long countOfBuyLotto = 3;
        Money money = Money.won(5000);

        Money result = money.spendOnLotto(countOfBuyLotto);

        assertThat(result).isEqualTo(Money.won(2000));
    }

    @DisplayName("구매한 금액과 당첨금이 동일하다")
    @Test
    void getRateOfReturn() {
        Money totalOfBuyMoney = Money.won(5000);
        Money totalOfPrizeMoney = Money.won(5000);

        double result = Money.getRateOfReturn(totalOfPrizeMoney, totalOfBuyMoney);

        assertThat(result).isEqualTo(100);
    }
}