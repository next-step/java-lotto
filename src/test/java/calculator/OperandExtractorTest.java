package calculator;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class OperandExtractorTest {

    @DisplayName("기본 구분자(, 와 :)으로 전달된 식에서 피연산자를 반환한다.")
    @Test
    public void getOperandDefaultSeparatorTest() {
        String testFormula = "1,2:3";

        String[] operand = OperandExtractor.getOperand(testFormula);

        assertThat(operand).containsAll(List.of("1", "2", "3"));
    }

    @DisplayName("Custom 구분자로 전달된 전달된 식에서 피연산자를 반환한다.")
    @Test
    public void getOperandCustomSeparatorTest() {
        String testFormula = "//;\n1;2;3";

        String[] operand = OperandExtractor.getOperand(testFormula);

        assertThat(operand).containsAll(List.of("1", "2", "3"));
    }

    @DisplayName("입력이 Null or Empty 일 때 \"0\" 이 리턴된다.")
    @ParameterizedTest
    @NullAndEmptySource
    public void getOperandNullAndEmptyTest(String value) {
        String[] operand = OperandExtractor.getOperand(value);

        assertThat(operand).containsOnly("0");
    }

    @DisplayName("숫자 하나만 입력되면 그 숫자를 리턴한다.")
    @Test
    public void getOperandOnlyOne() {
        String testFormula = "1";

        String[] operand = OperandExtractor.getOperand(testFormula);

        assertThat(operand).containsOnly("1");
    }
}