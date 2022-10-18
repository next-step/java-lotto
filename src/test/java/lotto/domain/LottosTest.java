package lotto.domain;

import lotto.generator.ManualNumberGenerator;
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
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto("1, 2, 3, 4, 5, 6"));
        lottoList.add(new Lotto("1, 2, 3, 4, 5, 10"));
        lottoList.add(new Lotto("1, 2, 3, 4, 5, 20"));
        lottoList.add(new Lotto("1, 2, 3, 4, 15, 20"));
        lottoList.add(new Lotto("1, 2, 3, 41, 15, 20"));
        lottoList.add(new Lotto("1, 2, 13, 41, 15, 20"));

        Lottos lottos = new Lottos(lottoList);
        Lotto winning = new Lotto("1, 2, 3, 4, 5, 6");
        LottoNumber bonus = LottoNumber.from(10);
        RankMap rankMap = lottos.getResult(winning, bonus);

        assertThat(rankMap.getRankCount(Rank.MISS)).isEqualTo(1);
        assertThat(rankMap.getRankCount(Rank.FIFTH)).isEqualTo(1);
        assertThat(rankMap.getRankCount(Rank.FOURTH)).isEqualTo(1);
        assertThat(rankMap.getRankCount(Rank.THIRD)).isEqualTo(1);
        assertThat(rankMap.getRankCount(Rank.SECOND)).isEqualTo(1);
        assertThat(rankMap.getRankCount(Rank.FIRST)).isEqualTo(1);
    }

    @Test
    public void 수익률_구하기() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto("1, 2, 3, 4, 5, 6"));
        lottoList.add(new Lotto("1, 2, 3, 4, 5, 6"));
        lottoList.add(new Lotto("1, 2, 3, 4, 5, 10"));
        lottoList.add(new Lotto("1, 2, 3, 4, 5, 10"));
        lottoList.add(new Lotto("1, 2, 3, 4, 15, 20"));
        lottoList.add(new Lotto("1, 2, 3, 4, 15, 20"));
        lottoList.add(new Lotto("1, 2, 3, 14, 15, 20"));
        lottoList.add(new Lotto("1, 2, 3, 14, 15, 20"));
        lottoList.add(new Lotto("1, 2, 13, 14, 15, 20"));
        lottoList.add(new Lotto("1, 2, 13, 14, 15, 20"));

        Lottos lottos = new Lottos(lottoList);
        Lotto winning = new Lotto("1, 2, 3, 4, 5, 6");
        LottoNumber bonus = LottoNumber.from(10);
        RankMap rankMap = lottos.getResult(winning, bonus);

        assertThat(rankMap.getProfitRate(lottos.lottosSize())).isEqualTo(0.8);
    }
}
