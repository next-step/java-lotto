package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class InputParserTest {

    @Test
    @DisplayName("계산식 중 피연산자 목록으로 분리하여 목록 생성")
    void parseOperand() {
        assertThat(new InputParser("10 + 5").parseOperand())
                .isEqualTo(Arrays.asList(10, 5));
    }

    @Test
    @DisplayName("계산식 중 연산자 목록으로 분리하여 목록 생성")
    void parseOperator() {
        assertThat(new InputParser("10 + 5 + 10").parseOperator())
                .isEqualTo(Arrays.asList("+", "+"));
    }
}
