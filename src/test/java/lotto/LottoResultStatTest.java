package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

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
        LottoResultStat stat = new LottoResultStat(results);
        assertThat(stat.getProfitMargin(price)).isEqualTo(400311000, withPrecision(0.000001));
    }
}
