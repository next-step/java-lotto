package calculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static calculator.model.OperatorParsing.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OperatorParsingTest {

    @Test
    @DisplayName("정상적인 연산식 리스트 저장 테스트")
    void 연산식_리스트_저장_테스트() {
        String[] formulas = new String[]{"2", "+", "3", "/", "2", "*", "4"};

        assertThat(addOperator(formulas)).isEqualTo(List.of("+", "/", "*"));
    }

    @Test
    @DisplayName("비정상적인 연산식 입력으로 연산식 리스트 저장 실패 테스트")
    void 연산식_리스트_저장_실패_테스트() {
        String[] formulas = new String[]{"2", "+", "3", "$", "5"};

        assertThatThrownBy(() -> addOperator(formulas))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("입력한 수식이 올바르지 않습니다.");
    }
}