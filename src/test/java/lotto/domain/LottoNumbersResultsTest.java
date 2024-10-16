package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersResultsTest {
    @Test
    void sumCashPrizes_로또_상금_합계를_반환한다() {
        LottoNumbersResults lottoSheetResults = new LottoNumbersResults(new HashMap<>() {{
            put(LottoCashPrize.valueOf("FOURTH"), 4);
            put(LottoCashPrize.valueOf("THIRD"), 3);
            put(LottoCashPrize.valueOf("SECOND"), 2);
            put(LottoCashPrize.valueOf("FIRST"), 1);
        }});

        assertThat(lottoSheetResults.sumCashPrizes()).isEqualTo(2_003_170_000);
    }
}
