package autoLotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void init() {
        lottoResult = new LottoResult(10);
    }

    @Test
    void addMatchCount() {
        lottoResult.addMatchCount(LottoPrize.THREE);
        lottoResult.addMatchCount(LottoPrize.FOUR);
        lottoResult.addMatchCount(LottoPrize.FOUR);

        assertEquals(1, lottoResult.getResult(LottoPrize.THREE));
        assertEquals(2, lottoResult.getResult(LottoPrize.FOUR));
        assertEquals(0, lottoResult.getResult(LottoPrize.FIVE));
        assertEquals(0, lottoResult.getResult(LottoPrize.SIX));
        assertEquals(0, lottoResult.getResult(LottoPrize.NONE));
    }
}
