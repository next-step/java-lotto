package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LottoResultTest {

    private LottoResult lottoResult;

    @Before
    public void setup() {
        lottoResult = new LottoResult(getDummyJackpots());
    }

    @Test
    public void 번호_3개일치_항목_개수체크() {
        lottoResult.matchNumberCount(Jackpot.SAME_3_NUMBERS);
    }

    private List<Jackpot> getDummyJackpots() {
        return Arrays.asList(
                Jackpot.SAME_0_NUMBERS,
                Jackpot.SAME_0_NUMBERS,
                Jackpot.SAME_1_NUMBERS,
                Jackpot.SAME_2_NUMBERS,
                Jackpot.SAME_3_NUMBERS,
                Jackpot.SAME_3_NUMBERS,
                Jackpot.SAME_3_NUMBERS,
                Jackpot.SAME_5_NUMBERS,
                Jackpot.SAME_6_NUMBERS
        );
    }
}
