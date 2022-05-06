package lotto.domain;

import lotto.exception.InvalidBonusNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningTicketTest {

    private LottoTicket lottoTicket;

    @BeforeEach
    void setUp() {
        lottoTicket = new LottoTicket(new TestGeneratorStrategy().generateLottoNumbers());
    }

    @Test
    @DisplayName("보너스 숫자가 당첨번호와 중복되면 InvalidBonusNumberException 발생")
    void throwInvalidBonusExceptionTest() {
        LottoNumber bonusNumber = lottoTicket.getLottoNumbers()
                .stream().findFirst().orElseThrow(IllegalArgumentException::new);

        assertThatThrownBy(() -> new WinningTicket(lottoTicket, bonusNumber))
                .isInstanceOf(InvalidBonusNumberException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 20, 30})
    @DisplayName("입력된 보너스 숫자와 당첨 티켓의 보너스 숫자가 같으면 true 반환")
    void isMatchBonusNumberTrueTest(int bonusNumber) {
        WinningTicket winningTicket = new WinningTicket(lottoTicket, new LottoNumber(bonusNumber));
        assertThat(winningTicket.isMatchBonusNumber(new LottoNumber(bonusNumber))).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"10:11", "20:30", "30:15"}, delimiter = ':')
    @DisplayName("입력된 보너스 숫자와 당첨 티켓의 보너스 숫자가 다르면 false 반환")
    void isMatchBonusNumberFalseTest(int bonusNumber, int inputBonusNumber) {
        WinningTicket winningTicket = new WinningTicket(lottoTicket, new LottoNumber(bonusNumber));
        assertThat(winningTicket.isMatchBonusNumber(new LottoNumber(inputBonusNumber))).isFalse();
    }
}