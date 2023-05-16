package lotto.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultsTest {

    @Test
    @DisplayName(value = "LottoResults 생성 검사")
    void test1() {
        LottoResults of = LottoResults.of();
        List<LottoResult> lottoResults = Arrays.asList(LottoResult.of(Rank.FIRST)
                , LottoResult.of(Rank.SECOND)
                , LottoResult.of(Rank.THIRD)
                , LottoResult.of(Rank.FOURTH)
                , LottoResult.of(Rank.NO_RANK));
        assertThat(of).isEqualTo(new LottoResults(lottoResults));
    }

    @Test
    @DisplayName(value = "로또 결과 매핑하여 map 으로 출력 검사")
    void test2() {
        Map<Rank, Long> map = new HashMap<>();
        for (Rank value : Rank.values()) {
            map.put(value, 0L);
        }
        assertThat(map).isEqualTo(LottoResults.of().groupingByLottoResult());
    }
}
