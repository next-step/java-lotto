package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SingleFormulaTest {

    @Test
    public void doOperateTest(){
        SingleFormula singleFormula = new SingleFormula(1, "+");
        singleFormula.doOperate(1);
        assertThat(singleFormula.doOperate(0)).isEqualTo(2);
    }
}