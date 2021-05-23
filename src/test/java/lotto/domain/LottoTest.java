package lotto.domain;

import lotto.domain.wrapper.LottoPurchase;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class LottoTest {

    @Test
    void 로또매칭_각각에_대한_결과_정확한_테스트케이스_Test() {
        LottoWinNumbers winNumbers = new LottoWinNumbers("1, 2, 3, 4, 5, 6", 7);

        Lotto lottoFirst = new Lotto(Arrays.asList(1,2,3,4,5,6));       // 6개 맞춤 + 보너스 무관, 1등, 2,000,000,000
        Lotto lottoSecond = new Lotto(Arrays.asList(1,2,3,4,5,7));      // 5개 맞춤 + 보너스 맞춤, 2등, 30,000,000
        Lotto lottoThird = new Lotto(Arrays.asList(2,3,4,5,6,8));       // 5개 맞춤 + 보너스 X  , 3등
        Lotto lottoFourth = new Lotto(Arrays.asList(3,4,5,6,7,8));      // 4개 맞춤 + 보너스 무관, 4등
        Lotto lottoFifth = new Lotto(Arrays.asList(4,5,6,7,8,9));       // 3개 맞춤 + 보너스 무관, 5등
        Lotto lottoMiss = new Lotto(Arrays.asList(7,8,9,10,11,12));     // 0개 맞춤 + 보너스 무관, -등(MISS)

        assertThat(winNumbers.matchResultOf(lottoFirst)).isEqualTo(LottoRank.FIRST);
        assertThat(winNumbers.matchResultOf(lottoSecond)).isEqualTo(LottoRank.SECOND);
        assertThat(winNumbers.matchResultOf(lottoThird)).isEqualTo(LottoRank.THIRD);
        assertThat(winNumbers.matchResultOf(lottoFourth)).isEqualTo(LottoRank.FOURTH);
        assertThat(winNumbers.matchResultOf(lottoFifth)).isEqualTo(LottoRank.FIFTH);
        assertThat(winNumbers.matchResultOf(lottoMiss)).isEqualTo(LottoRank.MISS);
    }

    @Test
    void 로또_기존결과에_보너스번호_Test() {
        LottoWinNumbers winNumbers = new LottoWinNumbers("1, 2, 3, 4, 5, 6", 7);

        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1,2,3,4,5,7)),          // 1개 - 5개 + 보너스 맞춤, 2등, 30,000,000
                new Lotto(Arrays.asList(1,2,3,4,5,6)),          // 1개 - 6개 맞춤, 1등, 2,000,000,000
                new Lotto(Arrays.asList(41,34,25,16,7,8))));    // 1개 - 0개 맞춤, -등,

        LottoResultPack resultPack = winNumbers.checkAllOf(lottos);

        assertThat(resultPack.countOf(LottoRank.FIRST)).isEqualTo(1);
        assertThat(resultPack.countOf(LottoRank.SECOND)).isEqualTo(1);
        assertThat(resultPack.countOf(LottoRank.MISS)).isEqualTo(1);
    }

    @Test
    void 로또결과들의_총수익률_Test() {
        LottoWinNumbers winNumbers = new LottoWinNumbers("1, 2, 3, 4, 5, 6", 7);
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1,4,5,6,17,38)),        // 1개 - 4개 맞춤, 3등, 50000
                new Lotto(Arrays.asList(1,2,3,4,5,6)),          // 1개 - 6개 맞춤, 1등, 2,000,000,000
                new Lotto(Arrays.asList(41,34,25,16,7,8))));    // 1개 - 0개 맞춤, -등,

        LottoResultPack resultPack = winNumbers.checkAllOf(lottos);

        assertThat(resultPack.calculateProfitRatio(new LottoPurchase(3000)))
                                            .isEqualTo(666683.3333, within(0.1));
    }

    @Test
    void 당첨번호와_로또들_비교_결과_Test() {
        LottoWinNumbers winNumbers = new LottoWinNumbers("1, 2, 3, 4, 5, 6", 7);
        Lottos lottos = new Lottos(Arrays.asList(
                                        new Lotto(Arrays.asList(1,4,5,6,17,38)),        // 4개 4등
                                        new Lotto(Arrays.asList(1,2,3,4,5,6)),          // 6개 1등
                                        new Lotto(Arrays.asList(41,34,25,16,7,8))));    // 0개 -등

        LottoResultPack resultPack = winNumbers.checkAllOf(lottos);

        assertThat(resultPack.countOf(LottoRank.MISS)).isEqualTo(1);
        assertThat(resultPack.countOf(LottoRank.FIFTH)).isEqualTo(0);
        assertThat(resultPack.countOf(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(resultPack.countOf(LottoRank.THIRD)).isEqualTo(0);
        assertThat(resultPack.countOf(LottoRank.SECOND)).isEqualTo(0);
        assertThat(resultPack.countOf(LottoRank.FIRST)).isEqualTo(1);
    }

    @Test
    void 로또와_당첨번호_비교_Test() {
        LottoWinNumbers winNumbers = new LottoWinNumbers("1, 2, 3, 4, 5, 6", 7);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(winNumbers.matchResultOf(lotto).matchCount()).isEqualTo(6);

        winNumbers = new LottoWinNumbers("1, 21, 13, 4, 5, 6", 7);
        lotto = new Lotto(Arrays.asList(1, 2, 13, 4, 3, 5));
        assertThat(winNumbers.matchResultOf(lotto).matchCount()).isEqualTo(4);
    }

    @Test
    void 입력된_유효하지않은_당첨번호_Test() {
        assertThatThrownBy(() -> new LottoWinNumbers("1, 2, 3, 4, 5, b", 7))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoWinNumbers("1, 2, 3, 4, 5", 7))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoWinNumbers("1, 2, 3, 4, 5, 6, 7", 7))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoWinNumbers("1, 2, 59, 4, 5, 5", 7))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoWinNumbers("1, 2, 3, -1, 5, 6", 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매개수만큼_로또_생성_Test() {
        LottoPurchase budget = new LottoPurchase(5000);
        Lottos lottos = new Lottos();
        lottos.buyAuto(budget.countOfAvailableAutoLotto());

        assertThat(lottos.count()).isEqualTo(5);
    }

    @Test
    void 유효한_로또구매금액_Test() {
        LottoPurchase budget = new  LottoPurchase(1000);
        assertThat(budget.equals(new LottoPurchase(1000)));
    }

    @Test
    void 유효하지않은_로또구매금액_Test() {
        assertThatThrownBy(() -> new LottoPurchase(999))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoPurchase(900))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
