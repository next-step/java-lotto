package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {

    @DisplayName("Numbers 객체 생성을 할 수 있다.")
    @Test
    void create() {
        String[] splitedString = new String[]{"1", "2"};
        Numbers expect = Numbers.valueOf(splitedString);

        Numbers actual = Numbers.valueOf(splitedString);

        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("합계를 구할 수 있다.")
    @Test
    void sum() {
        Numbers numbers = Numbers.valueOf(new String[]{"1", "2"});
        int expect = 3;

        int actual = numbers.sum();

        assertThat(actual).isEqualTo(expect);
    }
}
