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
                LottoResult.THIRD,
                LottoResult.FOURTH,
                LottoResult.FIFTH,
                LottoResult.SECOND,
                LottoResult.NONE
        );
        LottoResultStat stat = new LottoResultStat(results);
        assertThat(stat.getProfitMargin(1)).isEqualTo(338592500, withPrecision(0.000001));
    }
}
