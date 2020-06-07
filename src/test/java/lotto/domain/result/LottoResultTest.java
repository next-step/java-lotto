package lotto.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoResultTest {

    @DisplayName("구매금액에 따른 이익률을 반환한다")
    @Test
    void profit() {
        //given
        List<LottoPrize> statistics = createStatistics();

        //when
        LottoResult lottoResult = new LottoResult(statistics);

        //then
        assertThat(lottoResult.getRateOfProfit()).isEqualTo(20);
    }

    private List<LottoPrize> createStatistics() {
        return Arrays.asList(LottoPrize.FIFTH, LottoPrize.FIFTH, LottoPrize.FOURTH); // 60000, 3000
    }

}
