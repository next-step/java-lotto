package stringPlusCalculate.Domain;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class FormulaTest {

    @Test
    void formulaTest() {
        Formula formula = Formula.init("1,2");

        assertThat(formula).isEqualTo(Formula.init("1,2"));
    }

    @Test
    void isSplitterTest() {
        Formula formula = Formula.init("//;\\n1;2;3");

        assertThat(formula.isSplitter()).isTrue();
    }

    @Test
    void findSplitterTest() {
        Formula formula = Formula.init("//;\\n1;2;3");

        assertThat(formula.findSplitter()).isEqualTo(";");
    }

    @Test
    void determineSplitterTest() {
        Formula formula = Formula.init("//;\\n1;2;3");
        List<String> resultList = new ArrayList<>();
        resultList.add(";");

        assertThat(formula.determineSplitter()).isEqualTo(resultList);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2:1 2", "//;\\n1;2;3:1 2 3"})
    void splitArithmeticTargetTest(String input, String expected) {
        Formula formula = Formula.init(input);
        List<Double> resultList = Arrays.stream(expected.split(" ")).mapToDouble(Double::parseDouble).boxed().collect(Collectors.toList());

        ArithmeticTargets arithmeticTargetList = formula.arithmeticBySplit();

        assertThat(arithmeticTargetList.toList()).isEqualTo(resultList);
    }
}
