package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoWinningNumbersTest {
    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외 발생")
    void validateBonusNumber_duplicate() {
        LottoTicket winningNumbers = new LottoTicket(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = new LottoNumber(6);

        assertThatThrownBy(() -> new LottoWinningNumbers(winningNumbers, bonusNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되지 않을 경우 정상적으로 생성됨")
    void validateBonusNumber_notDuplicate() {
        LottoTicket winningNumbers = new LottoTicket(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = new LottoNumber(7);

        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumbers, bonusNumber);

        assertThat(lottoWinningNumbers.getWinningNumbers()).isEqualTo(winningNumbers);
        assertThat(lottoWinningNumbers.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @Test
    @DisplayName("당첨번호 개수 확인 ")
    void matchCount() {
        LottoTicket winningNumbers = new LottoTicket(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = new LottoNumber(7);
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumbers, bonusNumber);

        assertThat(lottoWinningNumbers.matchCount(new LottoTicket(1, 2, 3, 4, 5, 6))).isEqualTo(6);
        assertThat(lottoWinningNumbers.matchCount(new LottoTicket(1, 2, 3, 4, 5, 7))).isEqualTo(5);
        assertThat(lottoWinningNumbers.matchCount( new LottoTicket(1, 2, 3, 4, 10, 11))).isEqualTo(4);
    }

    @Test
    @DisplayName("보너스 당첨 여부 확인")
    void hasBonus() {
        LottoTicket winningNumbers = new LottoTicket(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = new LottoNumber(7);
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumbers, bonusNumber);

        assertThat(lottoWinningNumbers.hasBonus(new LottoTicket(1, 2, 3, 4, 5, 6))).isFalse();
        assertThat(lottoWinningNumbers.hasBonus(new LottoTicket(1, 2, 3, 4, 5, 7))).isTrue();
    }
}
