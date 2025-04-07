package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoPrizeTest {

    @Test
    @DisplayName("매치 6개일 경우 FIRST 반환 확인")
    public void testFirstPrize() {
        assertEquals(LottoPrize.FIRST, LottoPrize.from(6, false));
    }

    @Test
    @DisplayName("매치 5개 + 보너스 매치일 경우 SECOND 반환 확인")
    public void testSecondPrize() {
        assertEquals(LottoPrize.SECOND, LottoPrize.from(5, true));
    }

    @Test
    @DisplayName("매치 5개이나 보너스 미매치일 경우 THIRD 반환 확인")
    public void testThirdPrize() {
        assertEquals(LottoPrize.THIRD, LottoPrize.from(5, false));
    }

    @Test
    @DisplayName("매치 4개일 경우 FOURTH 반환 확인")
    public void testFourthPrize() {
        assertEquals(LottoPrize.FOURTH, LottoPrize.from(4, true));
        assertEquals(LottoPrize.FOURTH, LottoPrize.from(4, false));
    }

    @Test
    @DisplayName("매치 3개일 경우 FIFTH 반환 확인")
    public void testFifthPrize() {
        assertEquals(LottoPrize.FIFTH, LottoPrize.from(3, true));
        assertEquals(LottoPrize.FIFTH, LottoPrize.from(3, false));
    }

    @Test
    @DisplayName("매치가 2개 이하인 경우 MISS 반환 확인")
    public void testMissPrize() {
        assertEquals(LottoPrize.MISS, LottoPrize.from(2, false));
        assertEquals(LottoPrize.MISS, LottoPrize.from(0, false));
    }
}