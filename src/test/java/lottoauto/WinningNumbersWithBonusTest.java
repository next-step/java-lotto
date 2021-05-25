package lottoauto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersWithBonusTest {

    @DisplayName("보너스번호가 당첨번호에 이미 존재하는 경우")
    @Test
    void 보너스번호가_당첨번호에_이미_존재하는_경우() {
        LottoNumbers winningNumbers = new LottoNumbers("1,2,3,4,5,6");
        LottoNumber bonusNumber = new LottoNumber(6);

        assertThatThrownBy(()->new WinningNumbersWithBonus(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스번호는 당첨번호와 중복될 수 없습니다.");
    }

    @DisplayName("보너스번호가 당첨번호인지 여부")
    @Test
    void isHitBonusNumber() {
        LottoNumbers winningNumbers = new LottoNumbers("1,2,3,4,5,6");
        LottoNumber bonusNumber = new LottoNumber(7);

        WinningNumbersWithBonus winningNumbersWithBonus = new WinningNumbersWithBonus(winningNumbers, bonusNumber);

        assertThat(winningNumbersWithBonus.isHitBonusNumber(new LottoNumber(7))).isTrue();
        assertThat(winningNumbersWithBonus.isHitBonusNumber(new LottoNumber(5))).isFalse();

    }
}
