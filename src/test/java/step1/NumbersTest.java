package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step1.Numbers.NEGATIVE_NUMBER_EXCEPTION_MESSAGE;

public class NumbersTest {

    @Test
    void new_default() {
        String[] strings = {"1", "2", "3"};
        Numbers numbers = new Numbers(strings);

        assertThat(numbers.getNumbers()).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("음수의 값이 입력될 경우 Exception 처리 한다.")
    void new_negative() {
        String[] strings = {"-1", "2", "3"};

        assertThatThrownBy(() -> new Numbers(strings))
                .isInstanceOf(RuntimeException.class)
                .withFailMessage(NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
    }

}
