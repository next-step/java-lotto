package calculator.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumbersTest {

    @DisplayName("숫자인 문자들로 생성할 수 있다.")
    @Test
    void from() {
        Numbers expected = new Numbers(List.of(1, 2, 3));

        Numbers actual = Numbers.from(List.of("1", "2", "3"));

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("생성할 떼 숫자가 2개 미만이면 예외가 발생한다.")
    @Test
    void from_min_size() {
        ThrowingCallable actual = () -> new Numbers(List.of(1));

        assertThatThrownBy(actual)
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("적어도 숫자 2개의 숫자가 입력되어야 합니다.");
    }

    @DisplayName("숫자가 아닌 문자가 포함되어 있으면 예외가 발생한다.")
    @Test
    void from_contain_not_integer_string() {
        List<String> stringNumbers = List.of("1", "2", ".");

        ThrowingCallable actual = () -> Numbers.from(stringNumbers);

        assertThatThrownBy(actual)
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자의 위치에 숫자가 아닌 값이 입력되었습니다.");
    }

    @DisplayName("Numbers의 크기를 반환한다.")
    @Test
    void size() {
        int actual = new Numbers(List.of(1, 2, 3)).size();

        assertThat(actual).isEqualTo(3);
    }
}
