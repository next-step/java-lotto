package lotto.domain.lotto;

import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.view.InputView.COMMA_BLANK_DELIMITER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    @DisplayName("인스턴스 생성시 lottoNumbers의 크기가 LOTTO_NUMBER_SIZE와 다른 경우 IllegalArgumentException이 발생한다.")
    void testInstanceCreationFailCase() {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6, 7)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());

        assertThatThrownBy(() -> Lotto.valueOf(lottoNumbers))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"8, 21, 23, 41, 42, 43:0", "1, 3, 5, 14, 22, 45:3", "1, 3, 2, 4, 6, 5:6"}, delimiter = ':')
    @DisplayName("countOfMatch(): 로또 번호와 당첨 번호가 일치하는 번호의 개수를 반환한다.")
    void testCountOfMatch(String winningNumberInput, int expected) {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());

        WinningNumbers winningNumbers = WinningNumbers.valueOf(lottoNumbersForTest(winningNumberInput));
        Lotto lotto = Lotto.valueOf(lottoNumbers);

        assertThat(lotto.countOfMatch(winningNumbers)).isEqualTo(expected);
    }

    private Set<LottoNumber> lottoNumbersForTest(String winningNumbersInput) {
        return Arrays.stream(winningNumbersInput.split(COMMA_BLANK_DELIMITER))
                .map(number -> LottoNumber.valueOf(Integer.parseInt(number)))
                .collect(Collectors.toSet());
    }
}
