package lotto.domain.model.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTicketTest {

    @DisplayName("당첨 로또 티켓 생성 테스트")
    @Test
    void createWinningLottoTicket() {
        Set<LottoNumber> winningNumbers = createLottoNumbers(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = new LottoNumber(7);

        WinningLottoTicket winningTicket = new WinningLottoTicket(winningNumbers, bonusNumber);

        assertThat(winningTicket.getNumbers()).hasSize(6);
        assertThat(winningTicket.getNumbers()).isEqualTo(winningNumbers);
        assertThat(winningTicket.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @DisplayName("보너스 번호 중복 검증 테스트")
    @Test
    void validateBonusNumberDuplication() {
        Set<LottoNumber> winningNumbers = createLottoNumbers(1, 2, 3, 4, 5, 6);
        LottoNumber duplicatedBonusNumber = new LottoNumber(6);

        assertThatThrownBy(() -> new WinningLottoTicket(winningNumbers, duplicatedBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 당첨 번호와 중복될 수 없습니다");
    }

    private Set<LottoNumber> createLottoNumbers(final int... numbers) {
        Set<LottoNumber> lottoNumbers = new TreeSet<>();
        for (int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return lottoNumbers;
    }
} 
