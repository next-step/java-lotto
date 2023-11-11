package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stringcalculator.util.Parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParserTest {

    @Test
    @DisplayName("문자열 정수를 입력할 경우 해당하는 정수타입을 반환한다.")
    void parseInteger() {
        String inputString = "1";

        int result = Parser.parseInteger(inputString);

        assertThat(result).isOne();
    }

    @Test
    @DisplayName("문자열이 정수가 아닐경우 정수타입 파싱에 실패한다.")
    void parseInteger_문자() {
        String inputString = "가";

        assertThatIllegalArgumentException().isThrownBy(() -> Parser.parseInteger(inputString))
                .withMessageMatching("숫자 형식이 아닙니다.");
    }
}