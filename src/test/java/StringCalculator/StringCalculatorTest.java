package StringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Lotto Mission - Step1 테스트")
public class StringCalculatorTest {

    @Test
    @DisplayName("입력 숫자가 두 개일때 진행하는 테스트")
    public void calculateTest_TwoNumbers() {
        String[] value = "1,3".split(",|;");
        MissionCalculator calculator = new MissionCalculator(value);
        assertThat(calculator.calculate()).isEqualTo(4);
    }

    @Test
    @DisplayName("세 입력숫자에 대한 내용 테스트")
    void calculateTest_ThreeNumbers() {
        String[] value = "1,3;5".split(",|;");
        MissionCalculator calculator = new MissionCalculator(value);
        assertThat(calculator.calculate()).isEqualTo(9);
    }

    @Test
    @DisplayName("단일 입력에 대한 계산 확인")
    void calculateTest_OneNumber() {
        String[] value = "5".split(",|;");
        MissionCalculator calculator = new MissionCalculator(value);
        assertThat(calculator.calculate()).isEqualTo(5);
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
