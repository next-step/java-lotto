package lotto.domain.result;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class NumberOfResultsTest {

    @Test
    void 상금에_해당되는_결과만_저장한다() {
        List<LottoResult> lottoResults = Arrays.asList(
            LottoResult.NO_REWARD,
            LottoResult.FOUR_MATCHING,
            LottoResult.SIX_MATCHING
        );

        NumberOfResults numberOfResults = new NumberOfResults(lottoResults);
        boolean hasNoReward = numberOfResults.getRawNumberOfResults().keySet().stream()
            .anyMatch(lottoResult -> lottoResult == LottoResult.NO_REWARD);

        assertThat(hasNoReward).isFalse();
    }
}
