package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.TestLottoNumberFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @DisplayName("로또의 번호가 당첨 번호와 일치하는지 확인할 수 있다.")
    @Test
    void matchWinningNumber() {
        LottoTicket winningTicket = LottoTicket.of(
                TestLottoNumberFactory.createLottoNumbers(1, 2, 3, 4, 5 ,6)
        );
        WinningLotto winningLotto = WinningLotto.of(winningTicket, LottoNumber.of(7));

        assertThat(winningLotto.winningMatch(LottoNumber.of(1))).isTrue();
        assertThat(winningLotto.winningMatch(LottoNumber.of(7))).isFalse();
    }


    @DisplayName("로또 번호가 보너스 번호와 확인할 수 있다.")
    @Test
    void matchBonusNumber() {
        LottoTicket winningTicket = LottoTicket.of(
                TestLottoNumberFactory.createLottoNumbers(1, 2, 3, 4, 5 ,6)
        );
        int bonusNumber = 10;

        WinningLotto winningLotto = WinningLotto.of(winningTicket, LottoNumber.of(bonusNumber));

        assertThat(winningLotto.isBonusMatch(LottoNumber.of(bonusNumber))).isTrue();
        assertThat(winningLotto.isBonusMatch(LottoNumber.of(1))).isFalse();
    }

    @DisplayName("보너스 번호와 일치여부를 확인할 수 있다.")
    @Test
    void fromWinningNumbersAndBonusNumberTest() {
        List<String> winningNumbers = List.of("1", "2", "3", "4", "5", "6");
        int bonusNumber = 8;

        WinningLotto winningLotto = WinningLotto.fromWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);

        assertThat(winningLotto.isBonusMatch(LottoNumber.of(bonusNumber))).isTrue();
        assertThat(winningLotto.isBonusMatch(LottoNumber.of(1))).isFalse();
    }
}
