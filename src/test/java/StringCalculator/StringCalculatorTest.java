package StringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Lotto Mission - Step1 테스트")
public class StringCalculatorTest {

    @Test
    @DisplayName("입력 숫자가 두 개일때 진행하는 테스트")
    public void calculateTest_TwoNumbers() {
        assertThat(new MissionCalculator().splitAndCalculate("1,3")).isEqualTo(4);
    }

    @Test
    @DisplayName("세 입력숫자에 대한 내용 테스트")
    void calculateTest_ThreeNumbers() {
        assertThat(new MissionCalculator().splitAndCalculate("1,3;5")).isEqualTo(9);
    }

    @Test
    @DisplayName("단일 입력에 대한 계산 확인")
    void calculateTest_OneNumber() {
        assertThat(new MissionCalculator().splitAndCalculate("5")).isEqualTo(5);
    }

    @Test
    @DisplayName("음수 제약조건 확인")
    void calculateTest_ExceptionForNegativeNumber() {
        assertThatThrownBy(() -> new MissionCalculator().splitAndCalculate("-1,2"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("Custom Delimiter 입력시 분리여부 체크")
    void splitText_includingCustomDelimiter() {
        assertThat(new MissionCalculator().splitAndCalculate("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("텍스트 문자 포함될 경우 Exception 확인")
    void calculateTest_ExceptionForCharacterIncluded() {
        assertThatThrownBy(() -> new MissionCalculator().splitAndCalculate("30,13A"))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력값이 Null이거나 빈 값인 경우 테스트")
    void calculateTest_NullAndEmptyValueTest(String input) {
        assertThat(new MissionCalculator().splitAndCalculate(input)).isEqualTo(0);
    }

    @Test
    @DisplayName("값 중간에 Empty값 들어가 있어도 계산 잘하는지 확인")
    void calculateTest_calculationWithNullValueInMedium() {
        assertThat(new MissionCalculator().splitAndCalculate("//;\n1;;2;3")).isEqualTo(6);
    }
}
