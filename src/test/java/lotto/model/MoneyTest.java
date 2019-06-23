package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @DisplayName("돈을 생성한다")
    @Test
    void createMoney() {
        Assertions.assertThat(Money.wons(1000)).isEqualTo(Money.wons(1000));
    }

    @DisplayName("돈이 음수일 경우 에러발생")
    @Test
    void noNaturalMoneyThenFail() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Money.wons(-1));
    }
}