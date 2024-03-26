package calculator.code;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MathSignTest {

    @Test
    @DisplayName("기호 추출 테스트")
    void fromSignTest(){
        // Given
        final String plusSign = "+";

        // When
        MathSign actual = MathSign.fromSign(plusSign);

        // Then
        MathSign expected = MathSign.PLUS;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("부적합한 기호 예외 테스트")
    void unavailableSignThrowExceptionTest(){
        assertThatThrownBy(() -> {
            String unavailableSign = "(";
            MathSign.fromSign(unavailableSign);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바르지 않은 연산 기호입니다.");
    }
}
