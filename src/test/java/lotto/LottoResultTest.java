package lotto;

import lotto.model.LottoResult;
import lotto.model.Money;
import lotto.model.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    @DisplayName("로또 결과 테스트")
    @EnumSource(value = Rank.class)
    void 로또_결과_테스트() {
        Map<Rank, Long> rankMap = new HashMap<>();
        rankMap.put(Rank.three, 2L);
        rankMap.put(Rank.four, 1L);
        rankMap.put(Rank.five, 2L);
        rankMap.put(Rank.six, 1L);

        LottoResult lottoResult = new LottoResult(rankMap);

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
        Money buy = new Money(14000);
        Money profitPriceRes = Rank.of(3).getReward();
        double profitRateRes =  profitPriceRes.divide(buy);

        Map<Rank, Long> rankMap = new HashMap<>();
        rankMap.put(Rank.three, 1L);
        LottoResult lottoResult = new LottoResult(rankMap);

        assertThat(lottoResult.getProfitRate(buy)).isEqualTo(profitRateRes);
     }

    @Test
    @DisplayName("수익률 테스트")
    @EnumSource(value = Rank.class)
    void 당첨_수익률_테스트2(){
        Money buy = new Money(14000);
        Money profitPriceRes = Rank.of(3).getReward()
                .add(Rank.of(6).getReward());

        double profitRateRes =  profitPriceRes.divide(buy);

        Map<Rank, Long> rankMap = new HashMap<>();
        rankMap.put(Rank.three, 1L);
        rankMap.put(Rank.six, 1L);
        LottoResult lottoResult = new LottoResult(rankMap);


        assertThat(lottoResult.getProfitRate(buy)).isEqualTo(profitRateRes);
     }
}
