package lotto.backend.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @Test
    @DisplayName("1등 당첨")
    void rank_1st() {
        LottoTicket lottoTicket = LottoTicket.of(List.of(1, 3, 4, 36, 39, 40));
        WinningLotto winningLotto = WinningLotto.of(List.of(1, 3, 4, 36, 39, 40), 30);
        LottoRank rank = winningLotto.analysis(lottoTicket);
        assertThat(rank).isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("2등_보너스 당첨")
    void rank_2nd_with_bonus() {
        LottoTicket lottoTicket = LottoTicket.of(List.of(1, 3, 4, 36, 39, 40));
        WinningLotto winningLotto = WinningLotto.of(List.of(1, 3, 4, 36, 39, 45), 40);
        LottoRank rank = winningLotto.analysis(lottoTicket);
        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("2등 당첨")
    void rank_2nd() {
        LottoTicket lottoTicket = LottoTicket.of(List.of(1, 3, 4, 36, 39, 40));
        WinningLotto winningLotto = WinningLotto.of(List.of(1, 3, 4, 36, 39, 45), 41);
        LottoRank rank = winningLotto.analysis(lottoTicket);
        assertThat(rank).isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("3등 당첨")
    void rank_3rd() {
        LottoTicket lottoTicket = LottoTicket.of(List.of(1, 3, 4, 36, 39, 40));
        WinningLotto winningLotto = WinningLotto.of(List.of(1, 3, 4, 36, 37, 45), 40);
        LottoRank rank = winningLotto.analysis(lottoTicket);
        assertThat(rank).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    @DisplayName("4등 당첨")
    void rank_4th() {
        LottoTicket lottoTicket = LottoTicket.of(List.of(1, 3, 4, 36, 39, 40));
        WinningLotto winningLotto = WinningLotto.of(List.of(1, 3, 4, 20, 37, 45), 40);
        LottoRank rank = winningLotto.analysis(lottoTicket);
        assertThat(rank).isEqualTo(LottoRank.FIFTH);
    }
}
