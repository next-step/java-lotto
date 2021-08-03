package adder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultTokenizeStrategyTest {

    private final TokenizeStrategy tokenizeStrategy = new DefaultTokenizeStrategy();

    @Test
    @DisplayName("split 테스트")
    public void split() {
        // given
        Expression expression = new Expression("1,2:3");
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


}