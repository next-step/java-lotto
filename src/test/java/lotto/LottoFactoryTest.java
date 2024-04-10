package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoFactoryTest {

    @Test
    @DisplayName("티켓 구매 가능 개수 확인")
    void test01() {
        int money = 14000;
        List<Lotto> lottos = new LottoFactory().issueTicketsByMoney(money);
        assertThat(lottos.size()).isEqualTo(14);
    }

    @Test
    @DisplayName("수익률 확인")
    void test02() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> lottos = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45)),
                new Lotto(List.of(2, 8, 9, 18, 19, 21)),
                new Lotto(List.of(23, 25, 33, 36, 39, 41)),
                new Lotto(List.of(5, 9, 38, 41, 43, 44)),
                new Lotto(List.of(13, 14, 18, 21, 23, 35)),
                new Lotto(List.of(17, 21, 29, 37, 42, 45)),
                new Lotto(List.of(3, 8, 27, 30, 35, 44))
        );
        double rateOfReturn = 0.35;

        assertThat(new LottoFactory().calculateRateOfReturn(winningLotto, lottos)).isEqualTo(rateOfReturn);
    }

    @Test
    @DisplayName("당첨 통계 확인")
    void test03() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                new Lotto(List.of(1, 2, 4, 7, 8, 9)),
                new Lotto(List.of(1, 2, 7, 8, 9, 10)));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Rank> ranks = new LottoFactory().getRankResults(winningLotto, lottos);
        assertThat(ranks).contains(Rank.FIRST, Rank.SECOND, Rank.SECOND, Rank.FOURTH, Rank.NONE);
    }
}
