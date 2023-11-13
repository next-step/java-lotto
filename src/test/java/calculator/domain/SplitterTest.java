package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SplitterTest {

    @Test
    @DisplayName("입력값을 공백으로 분리했을 때 숫자만 리스트에 담겨 반환된다.")
    void split_number() {
        List<Integer> numbers = Splitter.splitNumbers("2 + 3 * 4 / 2");

        assertThat(numbers).containsExactly(2, 3, 4, 2);
    }

    @Test
    @DisplayName("입력값을 공백으로 분리했을 때 연산자만 리스트에 담겨 반환된다.")
    void split_operator() {
        List<String> operators = Splitter.splitOperators("2 + 3 * 4 / 2");

        assertThat(operators).containsExactly("+", "*", "/");
    }
}
