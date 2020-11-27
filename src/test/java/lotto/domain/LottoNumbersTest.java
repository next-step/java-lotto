package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumbersTest {

    public static final LottoNumbers WINNING_NUMBERS = new LottoNumbers("1, 2, 3, 4, 5, 6");

    @ParameterizedTest
    @DisplayName("입력받은 번호와 당첨번호의 일치하는 Rank를 반환한다.")
    @CsvSource(value = {
            "1, 7, 8, 9, 10, 11:1",
            "1, 2, 8, 9, 10, 11:2",
            "1, 2, 3, 9, 10, 11:3",
            "1, 2, 3, 4, 10, 11:4",
            "1, 2, 3, 4, 5, 11:5",
            "1, 2, 3, 4, 5, 6:6"
    }, delimiter = ':')
    void should_return_rank(String inputNumbers, int expectedCount) {
        //Given
        LottoNumbers lotto = new LottoNumbers(inputNumbers);

        //When
        Rank expectedRank = Rank.value(expectedCount);

        //Then
        assertThat(WINNING_NUMBERS.getRank(lotto)).isEqualTo(expectedRank);

    }

    @Test
    @DisplayName("입력한 번호에 따른 LottoNumber를 반환한다.")
    void should_return_winning_number() {
        //Given
        String inputNumbers = "1, 2, 3, 4, 5, 6";

        //When
        LottoNumbers lottoNumbers = new LottoNumbers(inputNumbers);

        //Then
        assertThat(lottoNumbers.getValue().stream()
                .map(LottoNumber::getValue)
                .collect(Collectors.toList())
        )
                .containsAll(Arrays.asList(1, 2, 3, 4, 5, 6));

    }

    @ParameterizedTest
    @DisplayName("입력한 당첨번호가 1~45 범위 밖의 수, 숫자가 6개가 아닐 때 IllegalArgumentException을 throw 한다.")
    @ValueSource(strings = {"1, 2, 4, 244, 12, 1", "1, 2, 3"})
    void should_throw_illegal_argument_exception(String numbers) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumbers(numbers))
                .withMessage(ErrorMessage.WINNING_NUMBER_ERROR);
    }

    @ParameterizedTest
    @DisplayName("중복된 숫자를 입력할 떄, Exception을 throw 한다.")
    @ValueSource(strings = {"1, 1, 1, 1, 12, 1"})
    void should_throw_illegal_argument_exception_when_duplicate_number(String numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumbers(numbers))
                .withMessage(ErrorMessage.NOT_ALLOW_DUPLICATED);
    }

    @ParameterizedTest
    @DisplayName("빈 문자열 입력하면, Exception을 반환한다")
    @ValueSource(strings = {"", " "})
    void should_return_zero_when_is_blank(String value) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumbers(value))
                .withMessage(ErrorMessage.WINNING_NUMBER_ERROR);
    }

    @Test
    @DisplayName("입력한 문자가 음수 이면, Exception을 반환한다.")
    void should_throw_illegal_argument_exception_when_is_negative_quantity() {
        //Given
        String values = "-1, -2, 3";

        //When & Then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumbers(values))
                .withMessage(ErrorMessage.NOT_ALLOW_NEGATIVE_QUANTITY);
    }
}
