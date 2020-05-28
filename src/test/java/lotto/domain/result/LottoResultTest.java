package lotto.domain.result;

import lotto.vo.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoResultTest {

    @DisplayName("구매금액에 따른 이익률을 반환한다")
    @Test
    void profit() {
        //given
        List<LottoPrize> statistics = createStatistics();

        //when
        LottoResult lottoResult = new LottoResult(statistics);

        //then
        assertAll(
                () -> assertThat(lottoResult.getRateOfProfit(Money.of(60000))).isEqualTo(1),
                () -> assertThat(lottoResult.getRateOfProfit(Money.of(120000))).isEqualTo(0.5)
        );
    }

    private List<LottoPrize> createStatistics() {
        return Arrays.asList(LottoPrize.FIFTH, LottoPrize.FIFTH, LottoPrize.FOURTH);
    }

}
