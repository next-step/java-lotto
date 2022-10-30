package lotto.backend.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        this.winningLotto = WinningLotto.of(List.of(1, 7, 10, 23, 40, 42), 20);
    }

    @Test
    @DisplayName("2000원으로 1등 과 2등_보너이 당첨됐을 경우 수익률")
    void profit() {
        LottoTickets purchasedLotto = new LottoTickets(List.of(
                LottoTicket.of(List.of(1, 7, 10, 23, 40, 42)), //6개 모두 일치 (1등)
                LottoTicket.of(List.of(1, 7, 20, 23, 40, 42)) //5개 + bonus (2등)
        ));
        LottoResult lottoResult = LottoResult.of(winningLotto, purchasedLotto);
        double expected = (double) (2000000000 + 3000000) / 2000;
        assertThat(lottoResult.getProfit()).isEqualTo(expected);
    }

    @Test
    @DisplayName("4000원으로 3등 2개 당첨됐을 경우 수익률")
    void profit_ver2() {
        //1, 7, 10, 23, 40, 42
        LottoTickets purchasedLotto = new LottoTickets(List.of(
                LottoTicket.of(List.of(1, 8, 11, 24, 41, 43)), //1개 일치
                LottoTicket.of(List.of(1, 7, 20, 25, 42, 45)), //3개 일치
                LottoTicket.of(List.of(1, 7, 20, 23, 44, 45)), //3개 일치
                LottoTicket.of(List.of(2, 15, 20, 25, 41, 42)) //0개 일치
        ));
        LottoResult lottoResult = LottoResult.of(winningLotto, purchasedLotto);
        double expected = (double) (LottoRank.FIFTH.getMoneyPrize() + LottoRank.FIFTH.getMoneyPrize()) / 4000;
        assertThat(lottoResult.getProfit()).isEqualTo(expected);
    }
}
