package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BlankSeparatorTest {

    @Test
    @DisplayName("빈칸을 기준으로 숫자와 연산자를 나누어서 StringCalculator 클래스를 반환해줍니다.")
    void makeStringCalculator() {
        // given
        String inputText = "2 + 3 * 4 / 2";
        BlankSeparator separator = new BlankSeparator();
        // when
        StringCalculator stringCalculator = separator.separateInputText(inputText);
        // then

        StringCalculator result = new StringCalculator(
                new Operators(List.of(Operator.PLUS, Operator.MULTIPLE, Operator.DIVIDE)),
                new Numbers(List.of(2, 3, 4, 2))
        );

        Assertions.assertThat(stringCalculator).isEqualTo(result);
    }

}