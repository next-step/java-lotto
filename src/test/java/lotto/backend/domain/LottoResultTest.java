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
    @DisplayName("2000원으로 로또 1개 3등 수익률")
    void profit() {
        LottoTickets LottoTickets = new LottoTickets();
        LottoTickets.add(List.of(
                LottoTicket.create(List.of(1, 7, 10, 22, 41, 44)),
                LottoTicket.create(List.of(2, 9, 12, 30, 40, 42))
        ));
        Money money = new Money(2000);
        LottoStatistics lottoStatistics = LottoStatistics.of(winningLotto, LottoTickets);
        LottoProfit lottoProfit = LottoProfit.of(lottoStatistics.prizeAmount(), money);

        double expected = (double) LottoRank.FIFTH.getMoneyPrize() / 2000;
        assertThat(lottoProfit.getValue()).isEqualTo(expected);
    }

    @Test
    @DisplayName("4000원으로 로또 1개 3등 수익률")
    void profit_ver2() {
        LottoTickets LottoTickets = new LottoTickets();
        LottoTickets.add(List.of(
                LottoTicket.create(List.of(1, 7, 10, 22, 41, 44)),
                LottoTicket.create(List.of(5, 11, 12, 30, 41, 45)),
                LottoTicket.create(List.of(4, 5, 6, 26, 27, 44)),
                LottoTicket.create(List.of(3, 4, 5, 6, 41, 45))
        ));
        LottoStatistics lottoStatistics = LottoStatistics.of(winningLotto, LottoTickets);
        LottoProfit lottoProfit = LottoProfit.of(lottoStatistics.prizeAmount(), new Money(4000));

        double expected = (double) LottoRank.FIFTH.getMoneyPrize() / 4000;
        assertThat(lottoProfit.getValue()).isEqualTo(expected);
    }
}
