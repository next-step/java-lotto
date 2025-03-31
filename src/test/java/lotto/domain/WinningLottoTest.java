package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    private static final WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 15);

    @Test
    @DisplayName("당첨 번호와 보너스 볼의 번호가 중복되면, 에러가 발생한다.")
    void throwIfBonusNumberIsDuplicated() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨된 로또 티켓과 비교하여 당첨 순위 3등을 반환한다.")
    void rankThird() {
        LottoTicket lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 7));
        assertThat(winningLotto.rank(lottoTicket)).isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("당첨된 로또 티켓과 비교하여 당첨 순위 2등을 반환한다.")
    void rankSecond() {
        LottoTicket lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 15));
        assertThat(winningLotto.rank(lottoTicket)).isEqualTo(LottoRank.SECOND);
    }
}