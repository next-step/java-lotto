package lotto.util;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

@DisplayName("텍스트 파서 클래스")
class TextParserTest {

    @Nested
    @DisplayName("로또 번호 파서는")
    class Describe_parseToLottoNumber {

        @Nested
        @DisplayName("로또 문자열이 주어지면")
        class Context_with_valid_text {
            final String text = "1,2,3,4,5,6";

            @DisplayName(",을 기준으로 로또 숫자 목록을 리턴한다")
            @Test
            void it_return_lotto_numbers() {
                List<LottoNumber> lottoNumbers = TextParser.parseToLottoNumbers(text);
                assertThat(lottoNumbers).containsExactly(
                        LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                        LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)
                );
            }
        }

        @Nested
        @DisplayName("유효하지 않은 로또 문자열이 주어지면")
        class Context_with_invalid_text {
            final String text = "a,b,d,e,f,g";

            @DisplayName("예외를 던진다")
            @Test
            void it_throws_exception() {
                assertThatExceptionOfType(NumberFormatException.class)
                        .isThrownBy(() -> TextParser.parseToLottoNumbers(text));
            }
        }

        @Nested
        @DisplayName("로또 숫자가 덜 입력된 문자열이 주어지면")
        class Context_with_not_enough_number_text {
            final String text = "1,2,3";

            @DisplayName("예외를 던진다")
            @Test
            void it_throws_exception() {
                assertThatExceptionOfType(IllegalArgumentException.class)
                        .isThrownBy(() -> TextParser.parseToLottoNumbers(text));
            }
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,2", "3,3"})
    void parseText(String input, int result) {
        assertThat(TextParser.parseToInt(input)).isEqualTo(result);
    }
}
