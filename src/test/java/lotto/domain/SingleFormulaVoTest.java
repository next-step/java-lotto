package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SingleFormulaVoTest {
    private static SingleFormulaVo tempSingleFormulaVo = new SingleFormulaVo();

    @Test
    public void isValidTest() {
        SingleFormulaVo singleFormulaVo = new SingleFormulaVo();
        singleFormulaVo.reset();
        assertThat(singleFormulaVo.isValid()).isFalse();

        singleFormulaVo.set("1");
        assertThat(singleFormulaVo.isValid()).isFalse();

        singleFormulaVo.reset();
        singleFormulaVo.set("+");
        assertThat(singleFormulaVo.isValid()).isFalse();

        singleFormulaVo.set("1");
        assertThat(singleFormulaVo.isValid()).isTrue();
    }

    @Test
    public void setTest() {
        SingleFormulaVo singleFormulaVo = new SingleFormulaVo();
        singleFormulaVo.set("1");
        assertThat(singleFormulaVo.getNumber()).isEqualTo(1);

        singleFormulaVo.set("+");
        assertThat(singleFormulaVo.getOperator()).isEqualTo("+");
    }

    @Test
    public void resetTest() {
        SingleFormulaVo singleFormulaVo = new SingleFormulaVo();
        singleFormulaVo.set("1");
        singleFormulaVo.set("+");
        assertThat(singleFormulaVo.getNumber()).isNotNull();
        assertThat(singleFormulaVo.getOperator()).isNotNull();

        singleFormulaVo.reset();
        assertThat(singleFormulaVo.getNumber()).isNull();
        assertThat(singleFormulaVo.getOperator()).isNull();
    }

    @Test
    public void exceptionTest1() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            SingleFormulaVo singleFormulaVo = new SingleFormulaVo();
            singleFormulaVo.set("a");
        });
    }

    @Test
    public void exceptionTest2() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            SingleFormulaVo singleFormulaVo = new SingleFormulaVo();
            singleFormulaVo.set("**");
        });
    }
}