package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    private LottoResult lottoResult;

    @Before
    public void setup() {
        lottoResult = new LottoResult(getDummyJackpots());
    }

    @Test
    public void 번호_3개일치_항목_개수체크() {
        int matchCount = lottoResult.matchCount(Jackpot.SAME_3_NUMBERS);
        assertThat(matchCount).isEqualTo(1);
    }

    @Test
    public void 번호_4개일치_항목_개수체크() {
        int matchCount = lottoResult.matchCount(Jackpot.SAME_4_NUMBERS);
        assertThat(matchCount).isEqualTo(0);
    }

    @Test
    public void 번호_5개일치_항목_개수체크() {
        int matchCount = lottoResult.matchCount(Jackpot.SAME_5_NUMBERS);
        assertThat(matchCount).isEqualTo(0);
    }

    @Test
    public void 번호_6개일치_항목_개수체크() {
        int matchCount = lottoResult.matchCount(Jackpot.SAME_6_NUMBERS);
        assertThat(matchCount).isEqualTo(0);
    }

    @Test
    public void 수익률_구하기() {
        double rate = lottoResult.calculatorRate();
        assertThat(rate).isEqualTo(0.35);
    }

    private List<Jackpot> getDummyJackpots() {
        return Arrays.asList(
                Jackpot.SAME_0_NUMBERS,
                Jackpot.SAME_0_NUMBERS,
                Jackpot.SAME_0_NUMBERS,
                Jackpot.SAME_0_NUMBERS,
                Jackpot.SAME_0_NUMBERS,
                Jackpot.SAME_0_NUMBERS,
                Jackpot.SAME_0_NUMBERS,
                Jackpot.SAME_1_NUMBERS,
                Jackpot.SAME_1_NUMBERS,
                Jackpot.SAME_2_NUMBERS,
                Jackpot.SAME_3_NUMBERS,
                Jackpot.SAME_0_NUMBERS,
                Jackpot.SAME_0_NUMBERS,
                Jackpot.SAME_0_NUMBERS
        );
    }
}
