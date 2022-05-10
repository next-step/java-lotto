package lotto;

import lotto.model.LottoResult;
import lotto.model.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoResultTest {

    @Test
    @DisplayName("로또 결과 테스트")
    @EnumSource(value = Rank.class)
    void 로또_결과_테스트() {
        LottoResult lottoResult = new LottoResult();

        Integer[] nums = {3, 3, 4, 5, 5, 6};
        for (int i = 0; i < nums.length; i++) {
            lottoResult.addCoincidenceCnt(nums[i]);
        }

        Integer[] res = {2, 1, 2, 1};
        int coincidence = 3;
        for (int i = 0; i < 4; i++) {
            assertThat(lottoResult.getResult(coincidence)).isEqualTo(res[i]);
            coincidence += 1;
        }
    }


    @Test
    @DisplayName("수익률 테스트")
    @EnumSource(value = Rank.class)
    void 당첨_수익률_테스트(){
        int buy = 14000;
        int profitPriceRes = Rank.of(3).getReward().getValue();
        double profitRateRes =  (double) profitPriceRes / buy;

        LottoResult lottoResult = new LottoResult();
        lottoResult.addCoincidenceCnt(3);

        assertThat(lottoResult.getProfitRate(buy)).isEqualTo(profitRateRes);
     }

    @Test
    @DisplayName("수익률 테스트")
    @EnumSource(value = Rank.class)
    void 당첨_수익률_테스트2(){
        int buy = 14000;
        int profitPriceRes = Rank.of(3).getReward()
                .add(Rank.of(6).getReward())
                .getValue();

        double profitRateRes =  (double) profitPriceRes / buy;

        LottoResult lottoResult = new LottoResult();
        lottoResult.addCoincidenceCnt(3);
        lottoResult.addCoincidenceCnt(6);

        assertThat(lottoResult.getProfitRate(buy)).isEqualTo(profitRateRes);
     }
}
