package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    @DisplayName("공백없는 문자열에 공백이 존재하는지 확인하여 없으면 에러를 던짐")
    void 문자열_공백_확인() {
        String text = " 2*2  ";

        StringCalculator stringCalculator = new StringCalculator(text);

        assertThatThrownBy(() -> stringCalculator.validateSpacing(text))
                .isInstanceOf(InputMismatchException.class);

    }

    @Test
    @DisplayName("연산 기호가 아닌경우 에러를 던진다")
    void 사칙연산_기호_확인() {
        String text = "2 + 10 / 3 + 6 / 3";
        String sign = "&";
        StringCalculator stringCalculator = new StringCalculator(text);
        assertThatThrownBy(() -> stringCalculator.isFourBasicOperation(sign)).isInstanceOf(InputMismatchException.class);

    }

    @Test
    @DisplayName("공백으로 문자열을 나눠서 만든 리스트 크기 확인")
    void 문자열_split_크기_확인() {
        String text = "2 * 2 / 32";
        StringCalculator stringCalculator = new StringCalculator(text);

        String[] result = stringCalculator.splitText();

        assertThat(result.length).isEqualTo(5);

    }


    @Test
    @DisplayName("사친연산 수행 결과를 확인한다")
    void 사칙연산_결과_확인() {
        String text = "2 + 10 / 3 + 6 / 3";

        StringCalculator stringCalculator = new StringCalculator(text);
        String[] array = stringCalculator.splitText();
        int result = stringCalculator.startOperation(array);

        assertThat(result).isEqualTo(3);

    }
}

