package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoPrizeTest {

    @Test
    @DisplayName("매치 6개일 경우 FIRST 반환 확인")
    public void testFirstPrize() {
        LottoMatch match = new LottoMatch(6, false);
        assertEquals(LottoPrize.FIRST, LottoPrize.from(match));
    }

    @Test
    @DisplayName("매치 5개 + 보너스 매치일 경우 SECOND 반환 확인")
    public void testSecondPrize() {
        LottoMatch match = new LottoMatch(5, true);
        assertEquals(LottoPrize.SECOND, LottoPrize.from(match));
    }

    @Test
    @DisplayName("매치 5개이나 보너스 미매치일 경우 THIRD 반환 확인")
    public void testThirdPrize() {
        LottoMatch match = new LottoMatch(5, false);
        assertEquals(LottoPrize.THIRD, LottoPrize.from(match));
    }

    @Test
    @DisplayName("매치 4개일 경우 FOURTH 반환 확인")
    public void testFourthPrize() {
        LottoMatch match = new LottoMatch(4, false);
        assertEquals(LottoPrize.FOURTH, LottoPrize.from(match));
    }

    @Test
    @DisplayName("매치 3개일 경우 FIFTH 반환 확인")
    public void testFifthPrize() {
        LottoMatch match = new LottoMatch(3, true); // bonus 여부와 상관없이 3개이면 FIFTH
        assertEquals(LottoPrize.FIFTH, LottoPrize.from(match));
    }

    @Test
    @DisplayName("매치가 2개 이하인 경우 MISS 반환 확인")
    public void testMissPrize() {
        LottoMatch match1 = new LottoMatch(2, false);
        LottoMatch match2 = new LottoMatch(0, false);
        assertEquals(LottoPrize.MISS, LottoPrize.from(match1));
        assertEquals(LottoPrize.MISS, LottoPrize.from(match2));
    }
}
