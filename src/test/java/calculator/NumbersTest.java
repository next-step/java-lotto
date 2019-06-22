package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    @DisplayName("numbers를 생성한다")
    @Test
    void createNumbers() {
        String[] numbersOfString = {"1", "2", "3"};
        Numbers numbers = Numbers.from(numbersOfString);
        assertThat(numbers).isNotNull();
        assertThat(numbers.getNumbers()).containsExactly(new Number(1), new Number(2), new Number(3));
    }
}