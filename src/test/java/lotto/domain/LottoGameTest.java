package lotto.domain;

import lotto.domain.wrapper.LottoPurchase;
import lotto.ui.LottoInputHandler;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class LottoGameTest {

    @Test
    void 로또게임_integration_Test() {
        int 로또총구매금액 = 6000;

        LottoGame lottoGame = new LottoGame(new LottoInputHandler() {
            @Override
            public int scanLottoPurchaseBudget() {
                return 로또총구매금액;
            }

            @Override
            public int scanCountOfManualLotto() {
                return 6;
            }

            @Override
            public List<String> scanManualLottos(int manualCount) {
                return Arrays.asList("1,2,3,4,5,6"      // 1등 1개
                                    , "2,3,4,5,6,7"     // 2등 1개
                                    , "2,3,4,5,6,8"     // 3등 1개
                                    , "3,4,5,6,7,8"     // 4등 1개
                                    , "4,5,6,7,8,9"     // 5등 1개
                                    , "5,6,7,8,9,10");  // MISS 1개
            }

            @Override
            public String scanLottoWinNumbersString() {
                return "1,2,3,4,5,6";
            }

            @Override
            public int scanLottoBonusNumber() {
                return 7;
            }
        });

        LottoResultPack result = lottoGame.start();

        // 순위별 개수
        assertThat(result.countOf(LottoRank.FIRST)).isEqualTo(1);
        assertThat(result.countOf(LottoRank.SECOND)).isEqualTo(1);
        assertThat(result.countOf(LottoRank.THIRD)).isEqualTo(1);
        assertThat(result.countOf(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(result.countOf(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(result.countOf(LottoRank.MISS)).isEqualTo(1);

        // 수익률
        assertThat(result.calculateProfitRatio(new LottoPurchase(로또총구매금액)))
                                                .isEqualTo(338592.5, within(0.1));
    }
}
