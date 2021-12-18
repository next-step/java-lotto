package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MatchedNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"1, 1, 3, 4, 5, 6, 7", "15, 14, 2, 1", "11, 12, 14, 15, 16", "40, 31, 31, 24, 1, 4"})
    @DisplayName("지난 당첨 번호가 중복이 존재하거나 6개가 아니면 예외를 던진다")
    public void notMatchedNumberCount(String inputText) {
        assertThatThrownBy(() -> {
            new MatchedNumber(inputText);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 13", "15, 14, 2, 12, 10, 33", "11, 12, 14, 15, 16, 40"})
    @DisplayName("유효한 당첨 번호를 받으면 객체는 정상적으로 생성된다")
    public void validMatchedNumber(String inputText) {
        assertThat(new MatchedNumber(inputText)).isNotNull();
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5, 13 : 2 : true",
            "15, 14, 2, 12, 10, 33 : 12 : true",
            "11, 12, 14, 15, 16, 40 : 16 : true",
            "1, 4, 5, 10, 15, 19 : 2 : false",
            "3, 10, 15, 16, 40, 45 : 11 : false"
    }, delimiter = ':')
    @DisplayName("로또 번호 하나를 인자로 받으면 현재 로또 번호에 포함여부를 반환한다")
    public void matchedNumber(String matchedText, int number, boolean expected) {
        MatchedNumber matchedNumber = new MatchedNumber(matchedText);

        assertThat(matchedNumber.matchedNumber(new LottoNumber(number))).isEqualTo(expected);
    }
}
