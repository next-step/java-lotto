package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SingleFormulaVoTest {

    @Test
    public void isValidTest() {
        SingleFormulaVo singleFormulaVo1 = new SingleFormulaVo();
        SingleFormulaVo singleFormulaVo2 = new SingleFormulaVo(1, null);
        SingleFormulaVo singleFormulaVo3 = new SingleFormulaVo(null, "+");
        SingleFormulaVo singleFormulaVo4 = new SingleFormulaVo(1, "+");

        assertThat(singleFormulaVo1.isValid()).isFalse();
        assertThat(singleFormulaVo2.isValid()).isFalse();
        assertThat(singleFormulaVo3.isValid()).isFalse();
        assertThat(singleFormulaVo4.isValid()).isTrue();
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
        SingleFormulaVo singleFormulaVo = new SingleFormulaVo(1, "+");
        assertThat(singleFormulaVo.getNumber()).isNotNull();
        assertThat(singleFormulaVo.getOperator()).isNotNull();

        singleFormulaVo.reset();
        assertThat(singleFormulaVo.getNumber()).isNull();
        assertThat(singleFormulaVo.getOperator()).isNull();
    }

    @Test
    public void exceptionTest1() {
        assertThatIllegalArgumentException().isThrownBy(()->{
            SingleFormulaVo singleFormulaVo = new SingleFormulaVo();
            singleFormulaVo.set("a");
        });
    }

    @Test
    public void exceptionTest2() {
        assertThatIllegalArgumentException().isThrownBy(()->{
            SingleFormulaVo singleFormulaVo = new SingleFormulaVo();
            singleFormulaVo.set("**");
        });
    }
}