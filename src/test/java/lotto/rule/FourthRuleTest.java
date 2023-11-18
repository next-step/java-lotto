package lotto.rule;

import lotto.Lotto;
import lotto.WinningNumber;
import lotto.type.WinningLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FourthRuleTest {
    @Test
    @DisplayName("[Fourth.getRank] 호출 시 -> 4등 enum 반환")
    public void getCorrectRank() {
        assertThat(FourthRule.getInstance().getRank())
                .isEqualTo(WinningLevel.FOURTH);
    }

    @Test
    @DisplayName("[FourthRule.isMatched] 딱 4개 일치 시 -> 조건 만족 판정")
    public void matchSuccessTest() {
        Lotto lotto = Lotto.of(List.of(1,2,3,4,5,6));
        WinningNumber winningNumber = WinningNumber.of(List.of(10,20,3,4,5,6), 7);

        assertThat(FourthRule.getInstance().isMatched(lotto, winningNumber)).isTrue();
    }

    @Test
    @DisplayName("[FourthRule.isMatched] 3개나 5개 일치 시 -> 조건 불만족 판정")
    public void matchFailTest() {
        Lotto lotto = Lotto.of(List.of(1,2,3,4,5,6));
        WinningNumber winningNumberMatch3 = WinningNumber.of(List.of(10,20,30,4,5,6), 7);
        WinningNumber winningNumberMatch5 = WinningNumber.of(List.of(10,2,3,4,5,6), 7);

        assertThat(FourthRule.getInstance().isMatched(lotto, winningNumberMatch3)).isFalse();
        assertThat(FourthRule.getInstance().isMatched(lotto, winningNumberMatch5)).isFalse();
    }
}