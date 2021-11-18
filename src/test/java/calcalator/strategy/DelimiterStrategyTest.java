package calcalator.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DelimiterStrategyTest {

    @Test
    @DisplayName("쉼표(,)로 구분자 테스트")
    void delimiterTest() {
        DelimiterStrategy delimiterStrategy = (input) -> input.split(",");
        String[] token = delimiterStrategy.getToken("1,2,3");
        assertThat(token).contains("1", "2", "3");
    }

    @Test
    @DisplayName("//;\n로 구분자 테스트")
    void customDelimiterTest() {
        DelimiterStrategy delimiterStrategy = new CustomDelimiter();
        String[] token = delimiterStrategy.getToken("//;\n1;2;3");
        assertThat(token).contains("1", "2", "3");
    }

}