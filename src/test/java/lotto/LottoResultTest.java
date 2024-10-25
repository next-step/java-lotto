package lotto;

import lotto.lotto.LottoResult;
import lotto.lotto.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    @DisplayName("LottoRank의 모든 값을 결과에 넣으면 결과에 +1씩 증가")
    void updateResult() {
        LottoResult result = new LottoResult();
        Arrays.stream(LottoRank.values()).forEach(lottoRank -> {
            result.updateResult(lottoRank);
        });

        assertThat(result.getResultMap().keySet()).containsExactlyInAnyOrder(LottoRank.values());
        Arrays.stream(LottoRank.values()).forEach((lottoRank) ->
                assertThat(result.getResultMap().get(lottoRank)).isEqualTo(1));
    }

}
