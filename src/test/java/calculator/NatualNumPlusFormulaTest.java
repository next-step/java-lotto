package calculator;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NatualNumPlusFormulaTest {

    @Test
    @DisplayName("더하기 테스트")
    public void plusTest() {
        NatualNumPlusFormula formula = new NatualNumPlusFormula(Lists.list(
                new NatualNum(1),
                new NatualNum(2),
                new NatualNum(3)
        ));

        assertThat(formula.sum()).isEqualTo(6);
    }

}