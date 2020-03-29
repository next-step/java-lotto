package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @DisplayName("빈문자열이나 null 입력시 0 반환")
    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = stringCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
        result = stringCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("문자하나 입력시 숫자하나 반환")
    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = stringCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("쉼표구분자 입력시 합 반환")
    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = stringCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("쉼표,콜론 구분자")
    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = stringCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자")
    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = stringCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("음수입력 valid 체크")
    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> stringCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }


}
