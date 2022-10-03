package calculator.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumbersTest {

    @Test
    void of() {
        Numbers expected = new Numbers(List.of(1, 2, 3));

        Numbers actual = Numbers.of(List.of("1", "2", "3"));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void of_min_size() {
        ThrowingCallable actual = () -> new Numbers(List.of(1));

        assertThatThrownBy(actual)
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("적어도 숫자 2개의 숫자가 입력되어야 합니다.");
    }

    @Test
    void of_contain_not_integer_string() {
        List<String> stringNumbers =  List.of("1", "2", ".");

        ThrowingCallable actual = () -> Numbers.of(stringNumbers);

        assertThatThrownBy(actual)
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자의 위치에 숫자가 아닌 값이 입력되었습니다.");
    }

    @Test
    void size() {
        int actual = new Numbers(List.of(1, 2, 3)).size();

        assertThat(actual).isEqualTo(3);
    }
}
