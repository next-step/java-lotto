package lotto.util;

import lotto.domain.LottoNumber;
import lotto.exception.NumberInputRuleException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringParserTest {

    @Test
    @DisplayName("성공 - 기본 구분자로 문자열을 분리하여 숫자로 된 리스트를 구할 수 있다.")
    void success_string_parse() {
        String text = "1, 2, 3, 4, 5, 6";
        int size = 6;

        List<LottoNumber> parseText = StringParser.parseToInts(text);

        assertThat(parseText).hasSize(size)
                .extracting("number")
                .containsOnly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("실패 - 번호 입력시 정해진 구분자에 맞춰서 입력을 하지 않으면 예외가 발생한다.")
    void fail_string_parse() {
        String text = "1,2,3,4,5,6";

        Assertions.assertThatThrownBy(() -> StringParser.parseToInts(text))
                .isInstanceOf(NumberInputRuleException.class)
                .hasMessage("번호 입력시 구분자는 ', '를 이용하여 입력하여야 합니다.");
    }

}
