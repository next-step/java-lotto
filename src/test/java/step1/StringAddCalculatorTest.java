package step1;

import org.junit.jupiter.api.DisplayName;
import step1.domain.StringAddCalculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("빈값테스트")
    public void splitAndSum_null_빈값테스트() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자하나일때테스트")
    public void splitAndSum_숫자하나() {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표구분자테스트")
    public void splitAndSum_쉼표구분자() {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표,콜론구분자테스트")
    public void splitAndSum_쉼표구분자_콜론구분자() {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀구분자테스트")
    public void splitAndSum_커스텀구분자() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        System.out.println(result);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_음수테스트() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3")).isInstanceOf(RuntimeException.class);

    }

}
