package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    private StringAddCalculator stringAddCalculator;

    @BeforeEach
    void init() {
        stringAddCalculator = new StringAddCalculator();
    }

    @Test
    @DisplayName("입력 값이 NULL이면 0을 반환하는 테스트")
    void sum_null() {
        int result = stringAddCalculator.sum(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("입력값이 빈 문자면 0을 반환하는 테스트")
    void sum_빈문자() {
        int result = stringAddCalculator.sum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("구분자가 없는 경우에도 split 되는지 테스트")
    void split_테스트() {
        int result = stringAddCalculator.sum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환하는 테스트")
    void sum_숫자_한개() {
        int result = stringAddCalculator.sum("3");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 하는 테스트")
    void sum_콤마_구분자_테스트() {
        int result = stringAddCalculator.sum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자 여러 개(콤마, 콜론)일때 숫자의 합을 더하는 하는 테스트")
    void sum_구분자_여러개_테스트() {
        int result = stringAddCalculator.sum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자를 사용하여 숫자의 합을 더하는 테스트")
    void sum_커스팀_구분자() throws Exception {
        int result = stringAddCalculator.sum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수가 들어왔을때 RuntimeException 발생 - 문자 1개")
    void sum_음수_문자1개_테스트() throws Exception {
        assertThatThrownBy(() -> {
            stringAddCalculator.sum("-1");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("음수가 들어왔을때 RuntimeException 발생 - 디폴트 구분자")
    void sum_음수_디폴트_구분자_테스트() throws Exception {
        assertThatThrownBy(() -> {
            stringAddCalculator.sum("-1,2,3");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("음수가 들어왔을때 RuntimeException 발생 - 커스텀 구분자")
    void sum_음수_커스텀_구분자_테스트() throws Exception {
        assertThatThrownBy(() -> {
            stringAddCalculator.sum("//;\n1;2;-3");
        }).isInstanceOf(RuntimeException.class);

    }
}
