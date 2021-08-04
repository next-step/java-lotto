package adder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TokenizeStrategyFactoryTest {

    @Test
    @DisplayName("기본 구분자 덧셈 테스트")
    public void basicDelimiter() {
        // given
        Expression expression = new Expression("1,2:3");
        Class<DefaultTokenizeStrategy> expectedClass = DefaultTokenizeStrategy.class;

        // when
        TokenizeStrategy tokenizeStrategy = TokenizeStrategyFactory.getTokenizeStrategy(expression);

        // then
        assertThat(tokenizeStrategy).isInstanceOf(expectedClass);
    }

    @Test
    @DisplayName("커스텀 구분자 덧셈 테스트")
    public void customDelimiter() {
        // given
        Expression expression = new Expression("//;\n1;2;3");
        Class<CustomTokenizeStrategy> expectedClass = CustomTokenizeStrategy.class;

        // when
        TokenizeStrategy tokenizeStrategy = TokenizeStrategyFactory.getTokenizeStrategy(expression);

        // then
        assertThat(tokenizeStrategy).isInstanceOf(expectedClass);
    }

}