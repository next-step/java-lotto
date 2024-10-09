package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OperatorsTest {

    @Test
    @DisplayName("연산자 목록에서 첫 번째 연산자 찾기 테스트")
    void operator_저장_테스트() {
        Operators operators = new Operators(new ArrayList<>(List.of("+", "-")));
        assertThat(operators.findOperator()).isEqualTo(List.of("+"));
    }

    @Test
    @DisplayName("연산자 리스트의 크기 저장 테스트")
    void operator_리스트_크기_저장_테스트() {
        Operators operators = new Operators(List.of("+", "-", "/"));

        assertThat(operators.size()).isEqualTo(3);
    }

}