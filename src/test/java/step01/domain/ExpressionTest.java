package step01.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.BDDAssertions.then;

class ExpressionTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("생성자 호출 시 value가 비어있는 경우 에러 발생.")
    void validateIsEmpty(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Expression(input));
    }

    @Test
    @DisplayName("createCalculationPreset 호출시 정상적으로 CalculationPreset가 생성되었는지 테스트.")
    void createCalculationPreset() {
        Expression expression = new Expression("1 + 2 - 3 / 4 * 5");

        CalculationPreset calculationPreset = new CalculationPreset(
            List.of(1, 2, 3, 4, 5),
            List.of(
                Operation.from("+"),
                Operation.from("-"),
                Operation.from("/"),
                Operation.from("*")
            )
        );

        then(expression.createCalculationPreset()).isEqualTo(calculationPreset);
    }
}