package lotto;

import lotto.domain.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NumberTest {
    @ParameterizedTest(name = "입력 숫자가 {0}일 경우 예외가 발생한다.")
    @ValueSource(ints = {0, 46})
    void create(int number) {
        assertThatThrownBy(() -> {
            Number.of(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("같은 숫자로 생성한 객체는 동일한 인스턴스이다.")
    @Test
    void equal() {
        assertThat(Number.of(10) == Number.of(10)).isTrue();
    }
}
