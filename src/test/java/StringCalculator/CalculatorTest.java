package StringCalculator;

import StringCalculator.Domain.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    @DisplayName("기본 구분자 split 테스트")
    void splitTest() {

        String str = "1,2:3";
        StringCalculator inputStrings = new StringCalculator(str);

        assertThat(inputStrings).isEqualTo(new StringCalculator(new ArrayList<>(Arrays.asList(1, 2, 3))));
    }

    @Test
    @DisplayName("숫자 이외의 값 혹은 음수 전달 시 exception 뱉어내는지 테스트")
    void stringExceptionTest() {

        String str = "1,-2:3";
        String str2 = "1,a:b";

        assertThatThrownBy(() -> new StringCalculator(str)).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("cannot be negative");
        assertThatThrownBy(() -> new StringCalculator(str2)).isInstanceOf(NumberFormatException.class);

    }

    @Test
    public void scustom_구분자() {
        StringCalculator stringCalculator = new StringCalculator("//;\n1;2;3");
        assertThat(stringCalculator).isEqualTo(new StringCalculator(new ArrayList<>(Arrays.asList(1, 2, 3))));
    }

    @Test
    public void sum_숫자하나() {
        StringCalculator stringCalculator = new StringCalculator("1");
        int result = stringCalculator.sum();
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void sum_쉼표구분자() {
        StringCalculator stringCalculator = new StringCalculator("1,2");
        int result = stringCalculator.sum();
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() {
        StringCalculator stringCalculator = new StringCalculator("//;\n1;2;3");
        int result = stringCalculator.sum();
        assertThat(result).isEqualTo(6);
    }


}
