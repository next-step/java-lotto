package calculator.domain.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("StringCalculator 클래스 테스트")
public class StringCalculatorTest {

    @DisplayName("문자열 List를 입력받아 Number List를 생성할 수 있다.")
    @Test
    void number () {
        String[] texts = {"1", "2", "3"};

        StringCalculator stringCalculator = new StringCalculator(texts);

        assertThat(stringCalculator).isNotNull();
        assertThat(stringCalculator.getNumbers().get(0).getNumber()).isEqualTo(1);
    }
}
