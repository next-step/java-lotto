package lotto.domain.wrapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class NumberTest {

    @DisplayName("1~45범위의 숫자를 인자로 받아 객체를 생성한다.")
    @Test
    void createNumber() {
        // given
        int input = 34;

        // when
        Number number = new Number(input);

        // then
        assertThat(number.number()).isEqualTo(34);
    }

    @DisplayName("생성시 인자로 받은 숫자가 1~45의 범위를 벗어나면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void createNumberWhenInputIsNotInRange(int input) {
        // when & then
        assertThatThrownBy(() -> new Number(input)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("숫자의 범위는 1~45입니다.");
    }

    @DisplayName("인자로 전달받은 Number객체의 값이 자신의 값과 동일한지 확인한다.")
    @Test
    void compareNumber() {
        // given
        int input = 5;
        Number origin = new Number(input);
        Number target = new Number(input);

        // when
        boolean isEqual = origin.compareWith(target);

        // then
        assertThat(isEqual).isTrue();
    }
}
