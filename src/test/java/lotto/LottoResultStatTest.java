package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

public class LottoResultStatTest {
    @Test
    void test_get_profit_margin() {
        List<LottoResult> results = List.of(
                LottoResult.FIRST,
                LottoResult.SECOND,
                LottoResult.THIRD,
                LottoResult.FOURTH,
                LottoResult.NONE
        );
        LottoPrice price = new LottoPrice(1);
        LottoPrizeInfo prizeInfo = new LottoPrizeInfo(Map.of(
                LottoResult.FIRST, 4,
                LottoResult.SECOND, 3,
                LottoResult.THIRD, 2,
                LottoResult.FOURTH, 1
        ));

        LottoResultStat stat = new LottoResultStat(results);
        assertThat(stat.getProfitMargin(price, prizeInfo)).isEqualTo(2, withPrecision(0.000001));
    }
}
