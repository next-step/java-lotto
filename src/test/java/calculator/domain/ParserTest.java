package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class ParserTest {

    @Test
    @DisplayName("입력값에서 피연산자 분리")
    void parseOperand() {
        assertThat(Parser.parseOperand(Arrays.asList("10", "+", "15"))).isEqualTo(Arrays.asList(10, 15));
    }

    @Test
    @DisplayName("입력값에서 연산자 분리")
    void parseOperator() {
        assertThat(Parser.parseOperator(Arrays.asList("10", "+", "15"))).isEqualTo(Arrays.asList("+"));
    }
}
