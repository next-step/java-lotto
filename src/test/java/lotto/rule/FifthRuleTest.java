package lotto.rule;

import lotto.Lotto;
import lotto.WinningNumber;
import lotto.type.WinningLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FifthRuleTest {
    @Test
    @DisplayName("[FifthRule.getRank] 호출 시 -> 5등 enum 반환")
    public void getCorrectRank() {
        assertThat(FifthRule.getInstance().getRank())
                .isEqualTo(WinningLevel.FIFTH);
    }

    @Test
    @DisplayName("[FifthRule.isMatched] 딱 3개 일치 시 -> 조건 만족 판정")
    public void matchSuccessTest() {
        Lotto lotto = Lotto.of(List.of(1,2,3,4,5,6));
        WinningNumber winningNumber = WinningNumber.of(List.of(10,20,30,4,5,6));

        assertThat(FifthRule.getInstance().isMatched(lotto, winningNumber)).isTrue();
    }

    @Test
    @DisplayName("[FirstRule.isMatched] 2개나 4개 일치 시 -> 조건 불만족 판정")
    public void matchFailTest() {
        Lotto lotto = Lotto.of(List.of(1,2,3,4,5,6));
        WinningNumber winningNumberMatch2 = WinningNumber.of(List.of(10,20,30,40,5,6));
        WinningNumber winningNumberMatch4 = WinningNumber.of(List.of(10,20,3,4,5,6));

        assertThat(FifthRule.getInstance().isMatched(lotto, winningNumberMatch2)).isFalse();
        assertThat(FifthRule.getInstance().isMatched(lotto, winningNumberMatch4)).isFalse();
    }
}