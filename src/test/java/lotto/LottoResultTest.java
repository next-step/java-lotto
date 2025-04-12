package lotto;

import lotto.model.LottoPrize;
import lotto.model.LottoResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void init() {
        lottoResult = new LottoResult(10);
    }

    @DisplayName("addMatchCount()는 인자에 해당하는 LottoPrize에 맞는 matchCount를 증가시킨다.")
    @Test
    void addMatchCount() {
        lottoResult.addMatchCount(LottoPrize.THIRD);
        lottoResult.addMatchCount(LottoPrize.FOURTH);
        lottoResult.addMatchCount(LottoPrize.FOURTH);

        assertEquals(0, lottoResult.getResult(LottoPrize.FIRST));
        assertEquals(0, lottoResult.getResult(LottoPrize.SECOND));
        assertEquals(1, lottoResult.getResult(LottoPrize.THIRD));
        assertEquals(2, lottoResult.getResult(LottoPrize.FOURTH));
        assertEquals(0, lottoResult.getResult(LottoPrize.MISS));
    }
}
