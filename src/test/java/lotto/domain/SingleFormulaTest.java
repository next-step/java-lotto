package lotto.domain;

import lotto.domain.SingleFormula;
import lotto.domain.SingleFormulaVo;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SingleFormulaTest {
    @Test
    public void doOperatePlusTest() {
        SingleFormula singleFormula = new SingleFormula();
        singleFormula.setNextSingleFormula(new SingleFormula(new SingleFormulaVo(1, "+")));
        assertThat(singleFormula.doOperate()).isEqualTo(1);
    }

    @Test
    public void doOperateMinusTest() {
        SingleFormula singleFormula = new SingleFormula();
        singleFormula.setNextSingleFormula(new SingleFormula(new SingleFormulaVo(1, "-")));
        assertThat(singleFormula.doOperate()).isEqualTo(-1);
    }

    @Test
    public void doOperateMultipleTest() {
        SingleFormula singleFormula = new SingleFormula(new SingleFormulaVo(1, "+"));
        singleFormula.setNextSingleFormula(new SingleFormula(new SingleFormulaVo(5, "*")));
        assertThat(singleFormula.doOperate()).isEqualTo(5);
    }

    @Test
    public void doOperateDivideTest() {
        SingleFormula singleFormula = new SingleFormula(new SingleFormulaVo(10, "+"));
        singleFormula.setNextSingleFormula(new SingleFormula(new SingleFormulaVo(2, "/")));
        assertThat(singleFormula.doOperate()).isEqualTo(5);
    }

    @Test
    public void doOperateTest() {
        // 1 - 2 * 3 + 4 - 5 + 6 * 7 - 8
        SingleFormula singleFormula = new SingleFormula(new SingleFormulaVo(1, "+"));
        singleFormula.setLastSingleFormula(new SingleFormula(new SingleFormulaVo(2, "-")));
        singleFormula.setLastSingleFormula(new SingleFormula(new SingleFormulaVo(3, "*")));
        singleFormula.setLastSingleFormula(new SingleFormula(new SingleFormulaVo(4, "+")));
        singleFormula.setLastSingleFormula(new SingleFormula(new SingleFormulaVo(5, "-")));
        singleFormula.setLastSingleFormula(new SingleFormula(new SingleFormulaVo(6, "+")));
        singleFormula.setLastSingleFormula(new SingleFormula(new SingleFormulaVo(7, "*")));
        singleFormula.setLastSingleFormula(new SingleFormula(new SingleFormulaVo(8, "-")));
        assertThat(singleFormula.doOperate(0)).isEqualTo(6);
    }
}