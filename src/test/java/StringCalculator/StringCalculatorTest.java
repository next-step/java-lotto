package StringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.*;

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
    void splitText_includingCustomDelimiter() {
        assertThat(new MissionCalculator().splitAndCalculate("//;\n1;2;3")).isEqualTo(6);
    }
}
