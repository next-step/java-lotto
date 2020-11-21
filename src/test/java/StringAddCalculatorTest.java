import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {
    // 1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    // 2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
    @Test
    public void splitAndSum_숫자하나() {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    // 3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
    @Test
    public void splitAndSum_쉼표구분자() {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }
}
