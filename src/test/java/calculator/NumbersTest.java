package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    @DisplayName("문자열 배열로 Numbers 객체를 생성한다.")
    @Test
    void create() {
        String[] numberArray = Splitter.split("1,2");
        Numbers numbers = Numbers.from(numberArray);
        assertThat(numbers.getNumbers()).containsExactly(1, 2);
    }

    @DisplayName("문자열로 넘어온 모든 숫자의 합을 구한다.")
    @Test
    void sum() {
        String[] numberArray = Splitter.split("1,2");
        Numbers numbers = Numbers.from(numberArray);
        assertThat(numbers.sum()).isEqualTo(3);
    }

}
