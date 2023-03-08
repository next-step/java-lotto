import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import letterCalculator.Calulator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class calculatorTest {

    @Test
    @DisplayName("쉼표(,)나 콜론(:)을 구분자로 사용한다 ")
    void inputTest() {
        final Calulator calulator = new Calulator("1,2:3");
//        assertThat(ca)
        calulator.calculator();
    }
    @DisplayName("빈 문자열 또는 null을 입력할 경우 0을 반환한다.")
    @Test
    void returnNull_or_0() {
        final Calulator calculator = new Calulator("");
        int result;
        result = calculator.calculator();
        assertThat(result).isEqualTo(0);
    }
    @DisplayName("빈 문자열 또는 null을 입력할 경우 0을 반환한다.")
    @Test
    void returnNull_or_0_2() {
        final Calulator calculator = new Calulator(null);
        int result;
        result = calculator.calculator();
        assertThat(result).isEqualTo(0);
    }
    @Test
    @DisplayName("음수는 사용할수 없다. ")
    void negativeNumberCheckTest() {
        final Calulator calulator = new Calulator("1,2:-3");
//        assertThat(ca)
        calulator.calculator();
    }
    @DisplayName("구분자 외의 숫자를 더할수 있다.")
    @Test
    void addNumber() {
        final Calulator calculator = new Calulator("1:2:3");
        int result;
        result = calculator.calculator();
        assertThat(result).isEqualTo(6);
    }
}
