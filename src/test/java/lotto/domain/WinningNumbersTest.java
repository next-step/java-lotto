package lotto.domain;

import lotto.domain.lotto.LottoNumber;
import lotto.exception.InvalidWinningNumbersException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.view.InputView.COMMA_BLANK_DELIMITER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {
    @ParameterizedTest
    @ValueSource(strings = {"1", "1, 2, 3, 4, 5, 6, 7", "1, 2, 3, 3, 5, 6"})
    @DisplayName("WinningNumbers 인스턴스 생성시 당첨 번호의 숫자 개수가 LOTTO_NUMBER_COUNT가 아닌 경우 IllegalArgumentException이 발생한다.")
    void testInstanceCreationFailCase(String winningNumbersInput) {
        Set<LottoNumber> lottoNumbers = lottoNumbersForTest(winningNumbersInput);
        assertThatThrownBy(() -> WinningNumbers.valueOf(lottoNumbers))
                .isExactlyInstanceOf(InvalidWinningNumbersException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5, 6:4:true", "1, 2, 3, 4, 5, 6:7:false"}, delimiter = ':')
    @DisplayName("contains(): 당첨 번호에 number가 포함되어 있다면 true를 없다면 false를 반환한다.")
    void testContains(String winningNumbersInput, int lottoNumber, boolean expected) {
        Set<LottoNumber> lottoNumbers = lottoNumbersForTest(winningNumbersInput);
        WinningNumbers winningNumbers = WinningNumbers.valueOf(lottoNumbers);
        assertThat(winningNumbers.contains(LottoNumber.valueOf(lottoNumber))).isEqualTo(expected);
    }

    private Set<LottoNumber> lottoNumbersForTest(String winningNumbersInput) {
        return Arrays.stream(winningNumbersInput.split(COMMA_BLANK_DELIMITER))
                .map(number -> LottoNumber.valueOf(Integer.parseInt(number)))
                .collect(Collectors.toSet());
    }
}
