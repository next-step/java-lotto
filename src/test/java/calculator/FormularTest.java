package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.*;

public class FormularTest {
    @ParameterizedTest
    @NullSource
    @EmptySource
    void 빈산식_오류검증(String testText) {
        assertThatThrownBy(()->getFormular(testText)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("산식이 입력 되지 않았습니다.");
    }


    @ParameterizedTest
    @ValueSource(strings = {"1+2+3","1 & 2", "1 + 1 -", "& 1"})
    void 산식패턴_오류검증(String testText) {
        assertThatThrownBy(()->getFormular(testText)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("산식이 잘 못 입력 되었습니다");
    }

    @Test
    @DisplayName("다음 피연산자 조회")
    void getNextOperand() {
        Formular formular = new Formular("1 + 2 * 3 - 1 / 2");
        assertThat(formular.getNextOperand().getValue()).isEqualTo(1);
        assertThat(formular.getNextOperand().getValue()).isEqualTo(2);
        assertThat(formular.getNextOperand().getValue()).isEqualTo(3);
        assertThat(formular.getNextOperand().getValue()).isEqualTo(1);
        assertThat(formular.getNextOperand().getValue()).isEqualTo(2);

    }

    @Test
    @DisplayName("입력순서대로 연산자 조회")
    void getNextOperator() {
        Formular formular = new Formular("1 + 2 * 3 - 1 / 2");
        assertThat(formular.getNextOperator().getValue()).isEqualTo("+");
        assertThat(formular.getNextOperator().getValue()).isEqualTo("*");
        assertThat(formular.getNextOperator().getValue()).isEqualTo("-");
        assertThat(formular.getNextOperator().getValue()).isEqualTo("/");

    }

    @Test
    void hasOperand() {
        Formular formular = new Formular("1 + 2");
        assertThat(formular.hasOperand()).isTrue();
        formular.getNextOperand();
        formular.getNextOperand();
        assertThat(formular.hasOperand()).isFalse();

    }

    private Formular getFormular(String inputFormular) {
        return new Formular(inputFormular);
    }
}
