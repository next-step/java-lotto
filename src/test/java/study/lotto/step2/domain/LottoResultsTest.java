package study.lotto.step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class LottoResultsTest {
    @Test
    void winning_amount() {
        // given
        LottoResults lottoResults = new LottoResults(
                List.of(LottoResult.MATCH_THREE_NUMBERS, LottoResult.MATCH_FOUR_NUMBERS)
        );

        // when
        Assertions.assertThat(lottoResults.winningAmount()).isEqualTo(55_000L);
    }
}