package lotto.domain.numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoNumbersTest {
    private WinningLottoNumbers winningLottoNumbers;

    @BeforeEach
    void setUp() {
        List<LottoNumber> winningNumbers = provideWinningNumbers();
        winningLottoNumbers = new WinningLottoNumbers(new LottoTicket(winningNumbers), new LottoNumber(7));
    }

    @DisplayName("당첨 번호 6개에 보너스 숫자가 포함되어 있으면, Exception 발생")
    @Test
    void validateBonusNumber() {
        List<LottoNumber> winningNumbers = provideWinningNumbers();
        assertThatThrownBy(() -> new WinningLottoNumbers(new LottoTicket(winningNumbers), new LottoNumber(4)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호 6개에 보너스 숫자가 포함 되어 있으면 안됩니다.");
    }

    @DisplayName("번호가 당첨번호 리스트(LottoTicket)에 포함되어 있으면 true 반환.")
    @ParameterizedTest
    @ValueSource(ints = {1, 4, 6})
    void isContain(int number) {
        boolean result = winningLottoNumbers.isContain(new LottoNumber(number));
        assertThat(result).isTrue();
    }

    @DisplayName("번호가 보너스 볼과 일치하면 true 반환.")
    @Test
    void isMatchBonusNumber1() {
        boolean result = winningLottoNumbers.isMatchBonusNumber(new LottoNumber(7));
        assertThat(result).isTrue();
    }

    @DisplayName("번호가 보너스 볼과 일치하지 않으면 false 반환.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 8})
    void isMatchBonusNumber2(int number) {
        boolean result = winningLottoNumbers.isMatchBonusNumber(new LottoNumber(number));
        assertThat(result).isFalse();
    }

    private List<LottoNumber> provideWinningNumbers() {
        return Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
