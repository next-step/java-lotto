package adder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CustomTokenizeStrategyTest {

    private final TokenizeStrategy tokenizeStrategy = new CustomTokenizeStrategy();

    @Test
    @DisplayName("custom 구분자 split 테스트")
    public void customSplit() {
        // given
        Expression expression = new Expression("//;\n1;2;3");
        int expectedSize = 3;
        String expectedOne = "1";
        String expectedTwo = "2";
        String expectedThree = "3";

        // when
        List<String> numbers = tokenizeStrategy.split(expression);

        // then
        assertThat(numbers.size()).isEqualTo(expectedSize);
        assertThat(numbers).containsExactly(expectedOne, expectedTwo, expectedThree);
    }

    @Test
    @DisplayName("containCustomDelimiter 테스트")
    public void containCustomDelimiter() {
        // given
        Expression expression = new Expression("//;\n1;2;3");
        boolean expected = true;

        // when
        boolean result = CustomTokenizeStrategy.containCustomDelimiter(expression);

        // then
        assertThat(result).isEqualTo(expected);
    }

}