package StringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Lotto Mission - Step1 테스트")
public class StringCalculatorTest {

    @Test
    @DisplayName("입력 숫자가 두 개일때 진행하는 테스트")
    public void calculateTest_TwoNumbers() {
        MissionCalculator calculator = new MissionCalculator();
        assertThat(calculator.splitAndCalculate("1,3")).isEqualTo(4);
    }

    @Test
    @DisplayName("세 입력숫자에 대한 내용 테스트")
    void calculateTest_ThreeNumbers() {
        MissionCalculator calculator = new MissionCalculator();
        assertThat(calculator.splitAndCalculate("1,3;5")).isEqualTo(9);
    }

    @Test
    @DisplayName("단일 입력에 대한 계산 확인")
    void calculateTest_OneNumber() {
        MissionCalculator calculator = new MissionCalculator();
        assertThat(calculator.splitAndCalculate("5")).isEqualTo(5);
    }

    @Test
    @DisplayName("음수 제약조건 확인")
    void calculateTest_ExceptionForNegativeNumber() {
        String[] value = "-1,2".split(",|;");
        MissionCalculator calculator = new MissionCalculator(value);
        assertThatThrownBy(calculator::calculate)
                .isInstanceOf(RuntimeException.class);
    }
}
