package lotto.domain;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumbersTest {

    private static final WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6", 7);
    private static final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    @Test
    @DisplayName("숫자가 6개가 아닐 때 IllegalArgumentException을 throw 한다.")
    void should_throw_illegal_argument_exception_when_less_than_six() {
        //Given
        List<LottoNumber> lottoNumbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3)
        );

        //When & Then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumbers(lottoNumbers))
                .withMessage(ErrorMessage.WINNING_NUMBER_ERROR);
    }

    @Test
    @DisplayName("중복된 숫자를 입력할 떄, Exception을 throw 한다.")
    void should_throw_illegal_argument_exception_when_duplicate_number() {

        //Given
        List<LottoNumber> numbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(3),
                new LottoNumber(5),
                new LottoNumber(6)
        );

        //When & Then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumbers(numbers))
                .withMessage(ErrorMessage.NOT_ALLOW_DUPLICATED);
    }
}
