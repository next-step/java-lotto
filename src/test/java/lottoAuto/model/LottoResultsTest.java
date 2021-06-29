package lottoAuto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultsTest {
    @DisplayName("Rank 객체를 참조해 등수를 구할 수 있다.")
    @Test
    public void lottoRankCountingTest(){
        LottoResults lottoResults = new LottoResults();
        lottoResults.add(new LottoResult(5,true));

        Map<Rank,Long> result = new HashMap<>();
        result.put(Rank.SECOND,Long.valueOf("1"));
        assertThat(result).isEqualTo(lottoResults.lottoRankCounting());
    }
}
