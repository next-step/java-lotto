package service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Operand;
import enums.Operator;

class InputValueParserTest {

    private static final String TEST_INPUT = "1 + 2";
    private InputValueParser inputValueParser;

    @BeforeEach
    void setUp() {
        inputValueParser = new InputValueParser(TEST_INPUT);
    }

    @Test
    @DisplayName("연산자만 파싱하는지 확인한다")
    void parsingOnlyOperatorsTest() {

        List<Operator> operators = inputValueParser.parsingOperators();
        assertThat(operators.contains(Operator.PLUS)).isTrue();
    }

    @Test
    @DisplayName("숫자만 파싱하는지 확인한다")
    void parsingOnlyOperandsTest() {

        List<Operand> operands = inputValueParser.parsingOperands();

        for (Operand value : operands) {
            assertThat(value.getOperand()).isInstanceOf(Integer.class);
        }
    }
}