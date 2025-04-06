package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LottoWinningsTest {

    @Test
    @DisplayName("보너스 번호가 당첨 번호에 포함되어 있으면 예외 발생")
    public void testBonusNumberInWinningNumbers() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 3;
        assertThrows(IllegalArgumentException.class, () -> new LottoWinnings(winningNumbers, bonusNumber));
    }

    @Test
    @DisplayName("보너스 번호가 유효 범위를 벗어나면 예외 발생")
    public void testBonusNumberOutOfRange() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 46;
        assertThrows(IllegalArgumentException.class, () -> new LottoWinnings(winningNumbers, bonusNumber));
    }

    @Test
    @DisplayName("올바른 당첨 번호와 보너스 번호 전달 시 예외 발생하지 않음")
    public void testValidLottoWinnings() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        assertDoesNotThrow(() -> new LottoWinnings(winningNumbers, bonusNumber));
    }

    @Test
    @DisplayName("isBonusMatch 메소드 검증")
    public void testIsBonusMatch() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        LottoWinnings lottoWinnings = new LottoWinnings(winningNumbers, bonusNumber);
        assertTrue(lottoWinnings.isBonusMatch(7));
        assertFalse(lottoWinnings.isBonusMatch(8));
    }

    @Test
    @DisplayName("countMatches 메소드로 당첨 결과 확인")
    public void testCountMatches() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        LottoWinnings lottoWinnings = new LottoWinnings(winningNumbers, bonusNumber);

        // 테스트 케이스 1: 1,2,3,4,5,7 -> 5개 매치, 보너스 매치 true
        Lotto ticket1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        LottoMatch match1 = lottoWinnings.countMatches(ticket1);
        assertEquals(5, match1.getMatchCount());
        assertTrue(match1.isBonusMatch());

        // 테스트 케이스 2: 1,2,3,4,7,8 -> 4개 매치, 보너스 매치 true
        Lotto ticket2 = new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8));
        LottoMatch match2 = lottoWinnings.countMatches(ticket2);
        assertEquals(4, match2.getMatchCount());
        assertTrue(match2.isBonusMatch());

        // 테스트 케이스 3: 1,2,3,10,11,12 -> 3개 매치, 보너스 매치 false
        Lotto ticket3 = new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12));
        LottoMatch match3 = lottoWinnings.countMatches(ticket3);
        assertEquals(3, match3.getMatchCount());
        assertFalse(match3.isBonusMatch());
    }
}
