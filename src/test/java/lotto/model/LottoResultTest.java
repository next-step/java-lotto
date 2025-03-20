package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void 결과_계산(){
        LottoResult lottoResult = new LottoResult(
                List.of(
                        LottoPrize.FIRST,
                        LottoPrize.SECOND,
                        LottoPrize.THIRD,
                        LottoPrize.FOURTH,
                        LottoPrize.NONE
                )
        );
        int profit = lottoResult.calculateProfit();

        assertThat(profit).isEqualTo(2000000000 + 1500000 + 50000 + 5000 + 0);

    }

}
