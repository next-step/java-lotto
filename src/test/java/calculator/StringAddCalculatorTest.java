package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @ParameterizedTest
    @DisplayName("입력값은 null 또는 빈문자일 수 없다.")
    @NullAndEmptySource
    public void splitAndSum_null_또는_빈문자(String inputValue) {
        assertThat(new StringAddCalculator().splitAndSum(inputValue)).isEqualTo(0);
    }

    @Test
    @DisplayName("문자가 들어있는지 체크한다.")
    public void isNumber() {
        assertThatThrownBy(() -> {
            new StringAddCalculator().splitAndSum("a");
        }).isInstanceOf(RuntimeException.class);
    }

    //    @Test
//    public void splitAndSum_숫자하나() throws Exception {
//        assertThat(new StringAddCalculator().splitAndSum("1")).isEqualTo(1);
//    }

//    @Test
//    public void splitAndSum_쉼표구분자() throws Exception {
//        int result = StringAddCalculator.splitAndSum("1,2");
//        assertThat(result).isEqualTo(3);
//    }

//    @Test
//    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
//        int result = StringAddCalculator.splitAndSum("1,2:3");
//        assertThat(result).isEqualTo(6);
//    }

//    @Test
//    public void splitAndSum_custom_구분자() throws Exception {
//        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
//        assertThat(result).isEqualTo(6);
//    }

//    @Test
//    public void splitAndSum_negative() throws Exception {
//        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
//                .isInstanceOf(RuntimeException.class);
//    }
}