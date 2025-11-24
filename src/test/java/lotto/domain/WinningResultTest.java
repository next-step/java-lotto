package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultTest {
    @Test
    void 당첨_결과를_생성한다() {
        LottoTickets tickets = createTickets(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(1, 2, 3, 7, 8, 9),
                new Lotto(10, 11, 12, 13, 14, 15)
        );
        Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = LottoNumber.of(7);
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonusNumber);

        WinningResult result = tickets.matchWith(winningNumbers);

        assertThat(result.getCountByRank(Rank.FIRST)).isEqualTo(1);
        assertThat(result.getCountByRank(Rank.FIFTH)).isEqualTo(1);
        assertThat(result.getCountByRank(Rank.MISS)).isEqualTo(1);
    }

    @Test
    void 총_당첨_금액_계산() {
        LottoTickets tickets = createTickets(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(1, 2, 3, 7, 8, 9)
        );
            Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);
            LottoNumber bonusNumber = LottoNumber.of(7);
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonusNumber);

        WinningResult result = tickets.matchWith(winningNumbers);

        assertThat(result.getTotalWinningAmount()).isEqualTo(2_000_005_000);
    }

    @Test
    void 수익률_계산() {
        LottoTickets tickets = createTickets(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(1, 2, 3, 7, 8, 9)
        );
        Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = LottoNumber.of(10);
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonusNumber);
        PurchaseAmount purchaseAmount = new PurchaseAmount(2000);

        WinningResult result = tickets.matchWith(winningNumbers);

        assertThat(result.calculateProfitRate(purchaseAmount)).isEqualTo(1000002.5);
    }

    private LottoTickets createTickets(Lotto... lottos) {
        List<Lotto> lottoList = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoList.add(lotto);
        }
        return new LottoTickets(lottoList, new ManualLottos(null));
    }

}
