package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Map;
import org.junit.Test;

public class LottoListTest {

    @Test
    public void LottoTicket() {
        final int lottosCount = 10;

        LottoList lottoList = new LottoList(lottosCount);

        assertThat(lottoList.size()).isEqualTo(lottosCount);
    }

    @Test(expected = RuntimeException.class)
    public void LottoTicket_로또_발급_갯수가_0이하() {
        final int lottosCount = 0;

        LottoList lottoList = new LottoList(lottosCount);

        assertThat(lottoList.size()).isEqualTo(lottosCount);
    }

    @Test
    public void getWinningResult() {
        final Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        final LottoList lottos = new LottoList(Arrays.asList(
            winningLotto,
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 44, 45)),
            new Lotto(Arrays.asList(1, 2, 3, 43, 44, 45)),
            new Lotto(Arrays.asList(1, 41, 42, 43, 44, 45)),
            new Lotto(Arrays.asList(40, 41, 42, 43, 44, 45))
        ));

        Map<Prize, LottoList> lottoResult = LottoMachine.getWinningResult(lottos, winningLotto);

        for (Prize prize : Prize.values()) {
            assertThat(lottoResult.get(prize).size()).isEqualTo(1);
        }
    }

    @Test
    public void getEarningsRate() {
        final long purchaseAmount = 4000;
        final Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        final LottoList lottos = new LottoList(Arrays.asList(
            winningLotto,
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 44, 45)),
            new Lotto(Arrays.asList(1, 2, 3, 43, 44, 45))
        ));

        Map<Prize, LottoList> lottoResult = LottoMachine.getWinningResult(lottos, winningLotto);

        long totalPrizeMoney = 0;

        for (Prize prize : Prize.values()) {
            totalPrizeMoney += lottoResult.get(prize).size() * prize.getMoney();
        }

        assertThat(LottoMachine.getEarningsRate(lottoResult, purchaseAmount)).isEqualTo(totalPrizeMoney / purchaseAmount);
    }

    @Test
    public void getEarningsRate_10개구매_3개일치_1개() {
        final long purchaseAmount = 10000;
        final Lotto winningLotto = new Lotto(Arrays.asList(45, 44, 43, 42, 41, 40));
        final LottoList lottos = new LottoList(Arrays.asList(
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
        ));

        Map<Prize, LottoList> lottoResult = LottoMachine.getWinningResult(lottos, winningLotto);

        long totalPrizeMoney = 0;
        for (Prize prize : Prize.values()) {
            totalPrizeMoney += lottoResult.get(prize).size() * prize.getMoney();
        }

        double result = LottoMachine.getEarningsRate(lottoResult, purchaseAmount);

        assertThat(result).isEqualTo((double) totalPrizeMoney / purchaseAmount);
    }
}