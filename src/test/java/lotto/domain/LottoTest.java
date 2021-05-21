package lotto.domain;

import jdk.jfr.Percentage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class LottoTest {

    @Test
    void 로또결과들의_총수익률_Test() {
        LottoWinNumbers winNumbers = new LottoWinNumbers("1, 2, 3, 4, 5, 6");
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1,4,5,6,17,38)),        // 1개 - 4개 맞춤, 3등, 50000
                new Lotto(Arrays.asList(1,2,3,4,5,6)),          // 1개 - 6개 맞춤, 1등, 2,000,000,000
                new Lotto(Arrays.asList(41,34,25,16,7,8))));    // 1개 - 0개 맞춤, -등,

        LottoResultPack resultPack = winNumbers.checkAllOf(lottos);

        assertThat(resultPack.calculateProfitRatio(new LottoPurchaseBudget(3000)))
                                            .isEqualTo(0.000001499962, within(0.0000001));
    }

    @Test
    void 당첨번호와_로또들_비교_결과_Test() {
        LottoWinNumbers winNumbers = new LottoWinNumbers("1, 2, 3, 4, 5, 6");
        Lottos lottos = new Lottos(Arrays.asList(
                                        new Lotto(Arrays.asList(1,4,5,6,17,38)),        // 4개 3등
                                        new Lotto(Arrays.asList(1,2,3,4,5,6)),          // 6개 1등
                                        new Lotto(Arrays.asList(41,34,25,16,7,8))));    // 0개 -등

        LottoResultPack resultPack = winNumbers.checkAllOf(lottos);

        assertThat(resultPack.countOf(LottoResult.MATCH_0)).isEqualTo(1);
        assertThat(resultPack.countOf(LottoResult.MATCH_1)).isEqualTo(0);
        assertThat(resultPack.countOf(LottoResult.MATCH_2)).isEqualTo(0);
        assertThat(resultPack.countOf(LottoResult.MATCH_3)).isEqualTo(0);
        assertThat(resultPack.countOf(LottoResult.MATCH_4)).isEqualTo(1);
        assertThat(resultPack.countOf(LottoResult.MATCH_5)).isEqualTo(0);
        assertThat(resultPack.countOf(LottoResult.MATCH_6)).isEqualTo(1);
    }

    @Test
    void 로또와_당첨번호_비교_Test() {
        LottoWinNumbers winNumbers = new LottoWinNumbers("1, 2, 3, 4, 5, 6");
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(winNumbers.matchResultOf(lotto).matchCount()).isEqualTo(6);

        winNumbers = new LottoWinNumbers("1, 21, 13, 4, 5, 6");
        lotto = new Lotto(Arrays.asList(1, 2, 13, 4, 3, 5));
        assertThat(winNumbers.matchResultOf(lotto).matchCount()).isEqualTo(4);
    }

    @DisplayName("랜덤으로 1~ 45 사이의 중복없는 번호들 생성")
    @Test
    void 구매_로또_번호생성_Test() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        String[] nums = lotto.lottoNumberString().substring(1, lotto.toString().length()-2).split(", |,");
        for (int i = 0; i < nums.length; ++i) {
            assertThat(Integer.parseInt(nums[i])).isGreaterThanOrEqualTo(1);
            assertThat(Integer.parseInt(nums[i])).isLessThanOrEqualTo(45);
        }
    }

    @Test
    void 입력된_유효하지않은_당첨번호_Test() {
        assertThatThrownBy(() -> new LottoWinNumbers("1, 2, 3, 4, 5, b"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoWinNumbers("1, 2, 3, 4, 5"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoWinNumbers("1, 2, 3, 4, 5, 6, 7"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoWinNumbers("1, 2, 59, 4, 5, 5"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoWinNumbers("1, 2, 3, -1, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매개수만큼_로또_생성_Test() {
        LottoPurchaseBudget budget = new  LottoPurchaseBudget(5000);
        LottoGame game = new LottoGame();
        Lottos lottos = game.buyLottos(budget.countOfAvailableLotto());

        assertThat(lottos.count()).isEqualTo(5);
    }

    @Test
    void 유효한_로또구매금액_Test() {
        LottoPurchaseBudget budget = new  LottoPurchaseBudget(1000);
        assertThat(budget.equals(new LottoPurchaseBudget(1000)));
    }

    @Test
    void 유효하지않은_로또구매금액_Test() {
        assertThatThrownBy(() -> new LottoPurchaseBudget(999))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoPurchaseBudget(900))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
