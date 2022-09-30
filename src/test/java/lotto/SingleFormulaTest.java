package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SingleFormulaTest {

    @Test
    public void doOperateTest(){
        // 1 - 2 * 3 + 4 - 5 + 6 * 7 - 8
        SingleFormula singleFormula1 = new SingleFormula(1, "+");
        SingleFormula singleFormula2 = new SingleFormula(2, "-");
        SingleFormula singleFormula3 = new SingleFormula(3, "*");
        SingleFormula singleFormula4 = new SingleFormula(4, "+");
        SingleFormula singleFormula5 = new SingleFormula(5, "-");
        SingleFormula singleFormula6 = new SingleFormula(6, "+");
        SingleFormula singleFormula7 = new SingleFormula(7, "*");
        SingleFormula singleFormula8 = new SingleFormula(8, "-");

        singleFormula1.setNextSingleFormula(singleFormula2);
        singleFormula2.setNextSingleFormula(singleFormula3);
        singleFormula3.setNextSingleFormula(singleFormula4);
        singleFormula4.setNextSingleFormula(singleFormula5);
        singleFormula5.setNextSingleFormula(singleFormula6);
        singleFormula6.setNextSingleFormula(singleFormula7);
        singleFormula7.setNextSingleFormula(singleFormula8);
        assertThat(singleFormula1.doOperate(0)).isEqualTo(6);
    }
}