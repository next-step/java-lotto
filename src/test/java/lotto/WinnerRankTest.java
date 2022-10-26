package lotto;

import lotto.common.type.WinnerRank;
import lotto.common.type.WinnerRankCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerRankTest {

    @Test
    @DisplayName("Miss WinnerCondition이 주어졌을 때 정상적인 WinnerRank 반환 확인")
    void testIfGetValidWinnerRank() {
        WinnerRankCondition winnerRankCondition = WinnerRankCondition.missCountFrom(0, false);
        assertThat(WinnerRank.valueOf(winnerRankCondition)).isEqualTo(WinnerRank.MISS);
    }

    @Test
    @DisplayName("한개 번호 일치 WinnerCondition이 주어졌을 때 정상적인 WinnerRank 반환 확인")
    void testIfGetValidWinnerRankWithOneCorrect() {
        WinnerRankCondition winnerRankCondition = WinnerRankCondition.missCountFrom(1, false);
        assertThat(WinnerRank.valueOf(winnerRankCondition)).isEqualTo(WinnerRank.MISS);
    }

    @Test
    @DisplayName("두개 번호 일치 WinnerCondition이 주어졌을 때 정상적인 WinnerRank 반환 확인")
    void testIfGetValidWinnerRankWithTwoCorrect() {
        WinnerRankCondition winnerRankCondition = WinnerRankCondition.missCountFrom(2, false);
        assertThat(WinnerRank.valueOf(winnerRankCondition)).isEqualTo(WinnerRank.MISS);
    }

    @Test
    @DisplayName("세개 번호 일치 WinnerCondition이 주어졌을 때 정상적인 WinnerRank 반환 확인")
    void testIfGetValidWinnerRankWithThreeCorrect() {
        WinnerRankCondition winnerRankCondition = WinnerRankCondition.missCountFrom(3, false);
        assertThat(WinnerRank.valueOf(winnerRankCondition)).isEqualTo(WinnerRank.FIFTH);
    }

    @Test
    @DisplayName("네개 번호 일치 WinnerCondition이 주어졌을 때 정상적인 WinnerRank 반환 확인")
    void testIfGetValidWinnerRankWithFourCorrect() {
        WinnerRankCondition winnerRankCondition = WinnerRankCondition.missCountFrom(4, false);
        assertThat(WinnerRank.valueOf(winnerRankCondition)).isEqualTo(WinnerRank.FORTH);
    }

    @Test
    @DisplayName("다섯개 번호 일치 WinnerCondition이 주어졌을 때 정상적인 WinnerRank 반환 확인")
    void testIfGetValidWinnerRankWithFiveCorrect() {
        WinnerRankCondition winnerRankCondition = WinnerRankCondition.missCountFrom(5, false);
        assertThat(WinnerRank.valueOf(winnerRankCondition)).isEqualTo(WinnerRank.THIRD);
    }

    @Test
    @DisplayName("2등 번호 일치 WinnerCondition이 주어졌을 때 정상적인 WinnerRank 반환 확인")
    void testIfGetValidWinnerRankWithSecondPlaceCorrect() {
        WinnerRankCondition winnerRankCondition = WinnerRankCondition.missCountFrom(5, true);
        assertThat(WinnerRank.valueOf(winnerRankCondition)).isEqualTo(WinnerRank.SECOND);
    }

    @Test
    @DisplayName("1등 번호 일치 WinnerCondition이 주어졌을 때 정상적인 WinnerRank 반환 확인")
    void testIfGetValidWinnerRankWithFirstPlaceCorrect() {
        WinnerRankCondition winnerRankCondition = WinnerRankCondition.missCountFrom(6, false);
        assertThat(WinnerRank.valueOf(winnerRankCondition)).isEqualTo(WinnerRank.FIRST);
    }
}
