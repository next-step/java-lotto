package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    public void 구매금액에_대한_로또_리스트_생성() {
        Lottos lottos = new Lottos().createAutoLottos(14000);
        assertThat(lottos.lottosSize()).isEqualTo(14);
    }

    @Test
    public void 당첨번호_통계() {
        Lottos lottos = new Lottos(LottoUtils.createTestLottos());
        Lotto winning = new Lotto("1, 2, 3, 4, 5, 6");
        LottoNumber bonus = LottoNumber.from(10);
        LottoResults lottoResults = lottos.getResult(winning, bonus);

        assertThat(lottoResults.getRankCount(Rank.MISS)).isEqualTo(2);
        assertThat(lottoResults.getRankCount(Rank.FIFTH)).isEqualTo(2);
        assertThat(lottoResults.getRankCount(Rank.FOURTH)).isEqualTo(2);
        assertThat(lottoResults.getRankCount(Rank.THIRD)).isEqualTo(1);
        assertThat(lottoResults.getRankCount(Rank.SECOND)).isEqualTo(1);
        assertThat(lottoResults.getRankCount(Rank.FIRST)).isEqualTo(2);
    }

    @Test
    public void 수익률_구하기() {
        Lottos lottos = new Lottos(LottoUtils.createTestLottos());
        Lotto winning = new Lotto("1, 2, 3, 4, 5, 6");
        LottoNumber bonus = LottoNumber.from(10);
        LottoResults lottoResults = lottos.getResult(winning, bonus);

        assertThat(lottoResults.getProfitRate(lottos.lottosSize())).isEqualTo(0.8);
    }
}
