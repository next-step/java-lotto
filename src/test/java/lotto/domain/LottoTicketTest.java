package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class LottoTicketTest {

    @Test
    public void LottoTicket() {
        final int lottosCount = 10;

        LottoTicket lottoTicket = new LottoTicket(lottosCount);

        assertThat(lottoTicket.getLottos().size()).isEqualTo(lottosCount);
    }

    @Test(expected = RuntimeException.class)
    public void LottoTicket_로또_발급_갯수가_0이하() {
        final int lottosCount = 0;

        LottoTicket lottoTicket = new LottoTicket(lottosCount);

        assertThat(lottoTicket.getLottos().size()).isEqualTo(lottosCount);
    }

    @Test
    public void getWinningResult() {
        final List<Lotto> lottos = Arrays.asList(
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 44, 45)),
            new Lotto(Arrays.asList(1, 2, 3, 43, 44, 45)),
            new Lotto(Arrays.asList(1, 41, 42, 43, 44, 45)),
            new Lotto(Arrays.asList(40, 41, 42, 43, 44, 45))
        );

        final LottoTicket lottoTicket = new LottoTicket(lottos);
        final Lotto winningLotto = lottoTicket.getLottos().get(0);

        Map<Integer, List<Lotto>> lottoResult = lottoTicket
            .getWinningResult(winningLotto.getLottoNumbers());

        for (Prize prize : Prize.values()) {
            assertThat(lottoResult.get(prize.getMatchingCount()).size()).isEqualTo(1);
        }
    }

    @Test
    public void getEarningsRate() {
        final int purchaseAmount = 4000;
        final List<Lotto> lottos = Arrays.asList(
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 44, 45)),
            new Lotto(Arrays.asList(1, 2, 3, 43, 44, 45))
        );

        final LottoTicket lottoTicket = new LottoTicket(lottos);
        final Lotto winningLotto = lottoTicket.getLottos().get(0);

        Map<Integer, List<Lotto>> lottoResult = lottoTicket
            .getWinningResult(winningLotto.getLottoNumbers());

        int totalPrizeMoney = 0;
        for (Prize prize : Prize.values()) {
            totalPrizeMoney += lottoResult.get(prize.getMatchingCount()).size() * prize.getMoney();
        }

        assertThat(lottoTicket.getEarningsRate(lottoResult, purchaseAmount)).isEqualTo(totalPrizeMoney / purchaseAmount);
    }

    @Test
    public void getEarningsRate_10개구매_3개일치_1개() {
        final int purchaseAmount = 10000;
        final List<Lotto> lottos = Arrays.asList(
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 44, 45)),
            new Lotto(Arrays.asList(1, 2, 3, 43, 44, 45))
        );

        final LottoTicket lottoTicket = new LottoTicket(lottos);
        final Lotto winningLotto = new Lotto(Arrays.asList(45, 44, 43, 42, 41, 40));

        Map<Integer, List<Lotto>> lottoResult = lottoTicket
            .getWinningResult(winningLotto.getLottoNumbers());

        int totalPrizeMoney = 0;
        for (Prize prize : Prize.values()) {
            totalPrizeMoney += lottoResult.get(prize.getMatchingCount()).size() * prize.getMoney();
        }

        double result = lottoTicket.getEarningsRate(lottoResult, purchaseAmount);

        assertThat(result).isEqualTo((double) totalPrizeMoney / purchaseAmount);
    }
}