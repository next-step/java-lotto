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
        assertThat(Money.wons(1000)).isEqualTo(Money.wons(1000));
    }

    @DisplayName("돈이 음수일 경우 exception")
    @Test
    void noNaturalMoneyThenFail() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Money.wons(-1));
    }

    @DisplayName("1개의 로또를 구매한다")
    @ParameterizedTest
    @ValueSource(ints = {
            1000,
            1500
    })
    void countAvailable(long amount) {
        Money money = Money.wons(amount);

        long count = money.countAvailable(Lotto.getPrice());

        assertThat(count).isEqualTo(1);
    }
}