package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.Number.MAX;
import static lotto.Number.MIN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NumberTest {

    @DisplayName("숫자를 생성하는데 성공한다.")
    @Test
    void createNumberSuccess() {
        Number number = Number.of(1);
        assertThat(number).isNotNull();
        assertThat(number).isEqualTo(Number.of(1));
    }

    @DisplayName("숫자가 " + MIN + "보다 작을 경우 exception")
    @Test
    void createMinLessThanBallThenFail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Number.of(MIN - 1))
                .withMessageMatching(String.format("로또숫자는 %d ~ %d 사이입니다.", MIN, MAX));
    }

    @DisplayName("숫자가 " + MAX + "보다 큰 경우 exception")
    @Test
    void createMaxGreaterThanBallThenFail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Number.of(MAX + 1))
                .withMessageMatching(String.format("로또숫자는 %d ~ %d 사이입니다.", MIN, MAX));
    }
}
