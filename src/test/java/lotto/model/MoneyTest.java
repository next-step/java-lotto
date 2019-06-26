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

    @DisplayName("1개의 로또를 구매한다")
    @ParameterizedTest
    @ValueSource(ints = {
            1000,
            1500
    })
    void countAvailable(long amount) {
        Money money = Money.won(amount);

        long count = money.countAvailable(Lotto.PRICE);

        assertThat(count).isEqualTo(1);
    }

    @DisplayName("로또 구입한 총 금액")
    @Test
    void calculateTotalByBuyLotto() {
        int count = 5;

        Money result =Money.calculateTotal(count);

        assertThat(result).isEqualTo(Money.won(5000));
    }
}