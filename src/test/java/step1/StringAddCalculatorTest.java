package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    private StringAddCalculator stringAddCalculator;

    @BeforeEach
    void init(){
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
    void sum_콤마_구분자_테스트(){
        int result = stringAddCalculator.sum("1,2");
        assertThat(result).isEqualTo(3);
    }

}
