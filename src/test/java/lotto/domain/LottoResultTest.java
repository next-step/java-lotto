package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    void create() {
        Map<LottoRank, Integer> resultMap = new HashMap<>();
        resultMap.put(LottoRank.FIRST, 1);
        resultMap.put(LottoRank.THIRD, 1);
        resultMap.put(LottoRank.FOURTH, 1);
        resultMap.put(LottoRank.FIFTH, 1);
        LottoResult lottoResult = new LottoResult(resultMap);

        assertThat(lottoResult).isEqualTo(new LottoResult(resultMap));
    }
}
