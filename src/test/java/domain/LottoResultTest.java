package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private Rank[] ranks = { Rank.First, Rank.First, Rank.Second, Rank.None };
    private LottoResult lottoResult = new LottoResult(ranks);

    @Test
    public void 순위를_그룹핑_한다() {
        assertThat(lottoResult.count(Rank.First)).isEqualTo(2);
        assertThat(lottoResult.count(Rank.Second)).isEqualTo(1);
    }

    @Test
    public void 당첨되지_않은_복권은_저장하지_않는다() {
        assertThat(lottoResult.count(Rank.None)).isEqualTo(0);
    }

    @Test
    public void 로또를_구매한_금액을_계산한다() {
        assertThat(lottoResult.calculateInvestMoney()).isEqualTo(ranks.length * LottoMachine.LOTTO_PRICE);
    }

    @Test
    public void 총_당첨금을_계산한다() {
        Long totalPrize = Rank.First.getPrizeMoney() * 2 + Rank.Second.getPrizeMoney();

        Long prizeMoney = lottoResult.calculatePrizeMoney();
        assertThat(prizeMoney).isEqualTo(totalPrize);
    }

    @Test
    public void 수익률을_계산한다() {
        Long totalPrize = Rank.First.getPrizeMoney() * 2 + Rank.Second.getPrizeMoney();

        Double profitRate = lottoResult.calculateProfitRate();
        assertThat(profitRate).isEqualTo(
            totalPrize.doubleValue() / (ranks.length * LottoMachine.LOTTO_PRICE));
    }
}
