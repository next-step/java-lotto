package step01.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.BDDAssertions.then;

class CalculationPresetTest {

    @Test
    @DisplayName("생성자 호출 시 numbers와 operations의 개수 체크 검증 성공")
    void validateIntegersAndOperationsSizeSuccess() {
        then(
            new CalculationPreset(
                List.of(1, 2),
                List.of(Operation.from("+"))
            )
        ).isInstanceOf(CalculationPreset.class);
    }

    @Test
    @DisplayName("생성자 호출 시 numbers와 operations의 개수 체크 검증 실패")
    void validateIntegersAndOperationsSizeFail() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            new CalculationPreset(
                List.of(1),
                List.of(Operation.from("+"))
            )
        );

        assertThatIllegalArgumentException().isThrownBy(() ->
            new CalculationPreset(
                List.of(1, 2, 3),
                List.of(Operation.from("+"))
            )
        );
    }
}