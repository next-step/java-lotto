package lotto.domain.numbers;

import lotto.domain.LottoNumberConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTicketTest {
    private WinningLottoTicket winningLottoTicket;

    @BeforeEach
    void setUp() {
        List<LottoNumber> winningNumbers = LottoNumberConverter.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        winningLottoTicket = new WinningLottoTicket(new LottoTicket(winningNumbers), LottoNumber.of(7));
    }

    @DisplayName("당첨 번호 6개에 보너스 숫자가 포함되어 있으면, Exception 발생")
    @Test
    void validateBonusNumber() {
        List<LottoNumber> winningNumbers = LottoNumberConverter.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new WinningLottoTicket(new LottoTicket(winningNumbers), LottoNumber.of(4)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호 6개에 보너스 숫자가 포함 되어 있으면 안됩니다.");
    }

    @DisplayName("로또 숫자가 당첨 숫자 리스트에 포함되어 있으면 true 반환.")
    @ParameterizedTest
    @ValueSource(ints = {1, 4, 6})
    void isContain(int number) {
        boolean result = winningLottoTicket.isContain(LottoNumber.of(number));
        assertThat(result).isTrue();
    }

    @DisplayName("로또 숫자가 보너스 볼과 일치하면 true 반환.")
    @Test
    void isMatchBonusNumber_true() {
        boolean result = winningLottoTicket.isMatchBonusNumber(LottoNumber.of(7));
        assertThat(result).isTrue();
    }

    @DisplayName("로또 숫자가 보너스 볼과 일치하지 않으면 false 반환.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 8})
    void isMatchBonusNumber_false(int number) {
        boolean result = winningLottoTicket.isMatchBonusNumber(LottoNumber.of(number));
        assertThat(result).isFalse();
    }
}
