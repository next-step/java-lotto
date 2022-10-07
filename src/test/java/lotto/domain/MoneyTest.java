package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MoneyTest {

    @DisplayName("0 보다 작은 숫자의 값으로 객체를 생성하면, 예외가 발생해야 한다.")
    @Test
    void create_givenNumberLessThanZero() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Money(-1));
    }

}
