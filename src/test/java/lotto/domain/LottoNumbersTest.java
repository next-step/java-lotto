package lotto.domain;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumbersTest {

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

    @Test
    @DisplayName("일치하는 숫자의 개수를 반환한다.")
    void should_return_matching_count() {
        //Given
        LottoNumbers lottoNumbers = lottoNumberGenerator.create("1, 2, 3, 4, 5, 6");
        LottoNumbers winning = lottoNumberGenerator.create("1, 2, 3, 7, 8, 9");

        //When
        int matchingCount = lottoNumbers.getMatchingCount(winning);

        //Then
        assertThat(matchingCount).isEqualTo(3);
    }
}
