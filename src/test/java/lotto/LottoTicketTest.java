package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.Winning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {
    @Test
    @DisplayName("로또(자동) 번호 중복 확인")
    void generateAutoLottoTicket_duplicate() {
        LottoTicket lottoTicket = LottoTicket.createAuto();
        assertThat(lottoTicket.getLottoNumbers()).doesNotHaveDuplicates();
    }

    @Test
    @DisplayName("로또(자동) 번호 개수 확인")
    void generateAutoLottoTicket_size() {
        LottoTicket lottoTicket = LottoTicket.createAuto();
        assertThat(lottoTicket.getLottoNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("로또(자동) 번호 범위 확인")
    void generateAutoLottoNumbers_range() {
        LottoTicket lottoTicket = LottoTicket.createAuto();
        for (LottoNumber lottoNumber : lottoTicket.getLottoNumbers()) {
            assertThat(lottoNumber.getNumber()).isBetween(1, 45);
        }
    }

    @Test
    @DisplayName("로또(수동) 번호 생성 확인")
    void generateLottoNumbers() {
        LottoTicket lottoTicket = new LottoTicket(11, 27, 43, 34, 25, 6);
        assertThat(lottoTicket.getLottoNumbers()
                              .stream()
                              .map(LottoNumber::getNumber)
                              .collect(Collectors.toList())).containsExactly(6, 11, 25, 27, 34, 43);
    }

    @Test
    @DisplayName("로또(수동) 번호가 6개가 아닌 경우 예외 발생")
    void generateLottoNumbers_notSix() {
        assertThatThrownBy(() -> new LottoTicket(1, 2, 3, 4, 5))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 번호는 정확히 서로 다른 숫자 6개여야 합니다.");
    }

    @Test
    @DisplayName("로또(수동) 번호가 중복된 경우 예외 발생")
    void generateLottoTicket_duplicate() {
        assertThatThrownBy(() -> new LottoTicket(1, 2, 3, 4, 5, 5))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 번호는 정확히 서로 다른 숫자 6개여야 합니다.");
    }

    @Test
    @DisplayName("로또 티켓 Winning 확인")
    void calculateWinningResult() {
        LottoTicket winningNumbers = new LottoTicket(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = new LottoNumber(7);
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumbers, bonusNumber);

        assertThat(new LottoTicket(1, 2, 3, 4, 5, 6).calculateWinningResult(lottoWinningNumbers)).isEqualTo(Winning.FIRST);
        assertThat(new LottoTicket(1, 2, 3, 4, 5, 7).calculateWinningResult(lottoWinningNumbers)).isEqualTo(Winning.SECOND);
        assertThat(new LottoTicket(1, 2, 3, 4, 5, 8).calculateWinningResult(lottoWinningNumbers)).isEqualTo(Winning.THIRD);
        assertThat(new LottoTicket(9, 10, 11, 12, 13, 14).calculateWinningResult(lottoWinningNumbers)).isEqualTo(Winning.NONE);
    }

    @Test
    @DisplayName("로또 번호 포함 확인")
    void contains() {
        LottoTicket lottoTicket = new LottoTicket(6, 11, 25, 27, 34, 43);
        LottoNumber includedNumber = new LottoNumber(6);
        LottoNumber notIncludedNumber = new LottoNumber(7);
        assertThat(lottoTicket.contains(includedNumber)).isTrue();
        assertThat(lottoTicket.contains(notIncludedNumber)).isFalse();
    }
}
