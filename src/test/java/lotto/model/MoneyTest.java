package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @DisplayName("돈을 생성한다")
    @Test
    void createMoney() {
        assertThat(Money.wons(1000)).isEqualTo(Money.wons(1000));
    }

    @DisplayName("돈이 음수일 경우 에러발생")
    @Test
    void noNaturalMoneyThenFail() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Money.wons(-1));
    }

    @DisplayName("1개의 로또를 구매 가능")
    @ParameterizedTest
    @ValueSource(ints = {
            1000,
            1500
    })
    void countAvailable(long amount) {
        Money money = Money.wons(amount);

        long count = money.countAvailableLotto();

        assertThat(count).isEqualTo(1);
    }
}