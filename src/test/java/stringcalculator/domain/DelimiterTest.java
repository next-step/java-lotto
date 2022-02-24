package stringcalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimiterTest {

    private Delimiter delimiter;

    @BeforeEach
    void setUp() {
        delimiter = new Delimiter();
    }

    @Test
    @DisplayName("기본 문자열을 가지고 입력된 문자열로 피연산자들을 추출한다.")
    void findOperandsWhenStringInputIsGiven() {
        final List<OperandNumber> operands = delimiter.findOperands("1 ,2: 3");
        assertThat(operands).isEqualTo(
            Arrays.asList(new OperandNumber(1), new OperandNumber(2), new OperandNumber(3)
            ));
    }
}
