package stringPlusCalculate;

import stringPlusCalculate.Domain.ArithmeticTargets;
import stringPlusCalculate.Domain.Formula;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FormulaTest {

    @Test
    void formulaTest() {
        Formula formula = Formula.init("1,2");

        assertThat(formula).isEqualTo(Formula.init("1,2"));
    }

    @Test
    void splitArithmeticTargetTest() {
        Formula formula = Formula.init("1,2");
        List<Double> resultList = new ArrayList<>();
        resultList.add(1.0);
        resultList.add(2.0);

        ArithmeticTargets arithmeticTargetList = formula.arithmeticBySplit();

        assertThat(arithmeticTargetList.toList()).isEqualTo(resultList);
    }
}
