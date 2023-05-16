package lotto.domain.result;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultsTest {
    @Test
    void test1() {
        LottoResults of = LottoResults.of();
        List<LottoResult> lottoResults = Arrays.asList(LottoResult.of(Rank.FIRST)
                , LottoResult.of(Rank.SECOND)
                , LottoResult.of(Rank.THIRD)
                , LottoResult.of(Rank.FOURTH)
                , LottoResult.of(Rank.NO_RANK));
        assertThat(of).isEqualTo(new LottoResults(lottoResults));
    }
}
