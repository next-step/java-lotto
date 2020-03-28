import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
        List<Double> resultList = new ArrayList<>(;
        resultList.add(1.0);
        resultList.add(2.0);

        ArtihmeticTargets arithmeticTargetList = formula.arithmeticBySplit("");

        assertThat(arithmeticTargetList).containsExactly(resultList);
    }
}
