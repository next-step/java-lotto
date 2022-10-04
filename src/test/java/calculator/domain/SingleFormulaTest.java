package calculator.domain;

import calculator.domain.SingleFormula;
import calculator.domain.SingleFormulaVo;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SingleFormulaTest {
    private static SingleFormulaVo tempSingleFormulaVo = new SingleFormulaVo();

    @Test
    public void doOperatePlusTest() {
        tempSingleFormulaVo.set("1");
        tempSingleFormulaVo.set("+");

        SingleFormula singleFormula = new SingleFormula();
        singleFormula.setNextSingleFormula(new SingleFormula(tempSingleFormulaVo));
        assertThat(singleFormula.doOperate()).isEqualTo(1);
    }

    @Test
    public void doOperateMinusTest() {
        tempSingleFormulaVo.set("1");
        tempSingleFormulaVo.set("-");

        SingleFormula singleFormula = new SingleFormula();
        singleFormula.setNextSingleFormula(new SingleFormula(tempSingleFormulaVo));
        assertThat(singleFormula.doOperate()).isEqualTo(-1);
    }

    @Test
    public void doOperateMultipleTest() {
        tempSingleFormulaVo.set("1");
        tempSingleFormulaVo.set("+");
        SingleFormula singleFormula = new SingleFormula(tempSingleFormulaVo);

        tempSingleFormulaVo.set("5");
        tempSingleFormulaVo.set("*");
        singleFormula.setNextSingleFormula(new SingleFormula(tempSingleFormulaVo));
        assertThat(singleFormula.doOperate()).isEqualTo(5);
    }

    @Test
    public void doOperateDivideTest() {
        tempSingleFormulaVo.set("10");
        tempSingleFormulaVo.set("+");
        SingleFormula singleFormula = new SingleFormula(tempSingleFormulaVo);

        tempSingleFormulaVo.set("2");
        tempSingleFormulaVo.set("/");
        singleFormula.setNextSingleFormula(new SingleFormula(tempSingleFormulaVo));
        assertThat(singleFormula.doOperate()).isEqualTo(5);
    }

    @Test
    public void doOperateTest() {
        // 1 - 2 * 3 + 4 - 5 + 6 * 7 - 8
        tempSingleFormulaVo.set("1");
        tempSingleFormulaVo.set("+");
        SingleFormula singleFormula = new SingleFormula(tempSingleFormulaVo);

        tempSingleFormulaVo.set("2");
        tempSingleFormulaVo.set("-");
        singleFormula.setLastSingleFormula(new SingleFormula(tempSingleFormulaVo));

        tempSingleFormulaVo.set("3");
        tempSingleFormulaVo.set("*");
        singleFormula.setLastSingleFormula(new SingleFormula(tempSingleFormulaVo));

        tempSingleFormulaVo.set("4");
        tempSingleFormulaVo.set("+");
        singleFormula.setLastSingleFormula(new SingleFormula(tempSingleFormulaVo));

        tempSingleFormulaVo.set("5");
        tempSingleFormulaVo.set("-");
        singleFormula.setLastSingleFormula(new SingleFormula(tempSingleFormulaVo));

        tempSingleFormulaVo.set("6");
        tempSingleFormulaVo.set("+");
        singleFormula.setLastSingleFormula(new SingleFormula(tempSingleFormulaVo));

        tempSingleFormulaVo.set("7");
        tempSingleFormulaVo.set("*");
        singleFormula.setLastSingleFormula(new SingleFormula(tempSingleFormulaVo));

        tempSingleFormulaVo.set("8");
        tempSingleFormulaVo.set("-");
        singleFormula.setLastSingleFormula(new SingleFormula(tempSingleFormulaVo));

        assertThat(singleFormula.doOperate(0)).isEqualTo(6);
    }
}