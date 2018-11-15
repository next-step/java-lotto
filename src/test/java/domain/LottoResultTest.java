package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    private LottoResult lottoResult;

    @Before
    public void setup() {
        lottoResult = new LottoResult(getDummyJackpots());
    }

    @Test
    public void 번호_3개일치_항목_개수체크() {
        int matchCount = lottoResult.matchCount(Rank.FIFTH);
        assertThat(matchCount).isEqualTo(1);
    }

    @Test
    public void 번호_4개일치_항목_개수체크() {
        int matchCount = lottoResult.matchCount(Rank.FOURTH);
        assertThat(matchCount).isEqualTo(0);
    }

    @Test
    public void 번호_5개일치_항목_개수체크() {
        int matchCount = lottoResult.matchCount(Rank.THIRD);
        assertThat(matchCount).isEqualTo(0);
    }

    @Test
    public void 번호_6개일치_항목_개수체크() {
        int matchCount = lottoResult.matchCount(Rank.FIRST);
        assertThat(matchCount).isEqualTo(0);
    }

    @Test
    public void 수익률_구하기() {
        double rate = lottoResult.calculatorRate();
        assertThat(rate).isEqualTo(1.0);
    }

    private List<Rank> getDummyJackpots() {
        return Arrays.asList(
                Rank.MISS,
                Rank.MISS,
                Rank.FIFTH,
                Rank.MISS,
                Rank.MISS
        );
    }
}
