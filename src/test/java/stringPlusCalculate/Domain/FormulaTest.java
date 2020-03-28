package stringPlusCalculate.Domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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
    void determineSplitterWhenDefaultTest() {
        Formula formula = Formula.init("1;2;3");
        List<String> resultList = new ArrayList<>();
        resultList.add(":");
        resultList.add(",");

        assertThat(formula.determineSplitter()).isEqualTo(resultList);
    }

    @Test
    void determineSplitterTest() {
        Formula formula = Formula.init("//;\\n1;2;3");
        List<String> resultList = new ArrayList<>();
        resultList.add(";");

        assertThat(formula.determineSplitter()).isEqualTo(resultList);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:1 2", "//;\\n1;2;3:1 2 3"}, delimiter = ':')
    void splitArithmeticTargetTest(String input, String expected) {
        Formula formula = Formula.init(input);
        List<Double> resultList = Arrays.stream(expected.split(" ")).mapToDouble(Double::parseDouble).boxed().collect(Collectors.toList());

        ArithmeticTargets arithmeticTargetList = formula.arithmeticBySplit();

        assertThat(arithmeticTargetList.toList()).isEqualTo(resultList);
    }

    @Test
    void splitArithmeticTarget_null_들어오는경우_Test() {
        Formula formula = Formula.init("".trim());
        List<Double> resultList = new ArrayList<>();

        ArithmeticTargets arithmeticTargetList = formula.arithmeticBySplit();

        assertThat(arithmeticTargetList.toList()).isEqualTo(resultList);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,-2", "a,2", "a,-2"})
    void splitArithmeticTarget_음수_문자_들어오는경우_Test(final String input) {

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            Formula formula = Formula.init(input);
            formula.arithmeticBySplit();
        });

    }
}
