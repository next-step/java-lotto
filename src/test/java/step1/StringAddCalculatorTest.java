package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StringAddCalculatorTest {

    @ParameterizedTest(name = "계산기 합산 테스트")
    @ValueSource(strings = {"1,3,5", "1:3:5", "9,0", "9"})
    void splitAndSum(String given) {
        // given
        int expected = 1+3+5;

        // when
        int actual = StringAddCalculator.splitAndSum(given);

        // then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("초기값 테스트")
    void isNullinitValue() {
        // given
        String given = "";

        // when
        boolean actual = given == null || given.isEmpty();

        // then
        assertTrue(actual);
    }

    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest(name = "음수 숫자하나에 대한 연산 테스트")
    @ValueSource(strings = {"-1", "-2"})
    public void splitAndSum_음수하나(String given) throws Exception {
        assertThatThrownBy(
                () -> StringAddCalculator.splitAndSum(given)
        ).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest(name = "양수 숫자하나에 대한 연산 테스트")
    @ValueSource(strings = {"1", "2"})
    public void splitAndSum_양수하나(String given) throws Exception {
        int result = StringAddCalculator.splitAndSum(given);

        assertThat(result).isEqualTo(Integer.parseInt(given));
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
