package lotto.rule;

import lotto.Lotto;
import lotto.WinningNumber;
import lotto.type.WinningLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SecondRuleTest {
    @Test
    @DisplayName("[SecondRule.getRank] 호출 시 -> 2등 enum 반환")
    public void getCorrectRank() {
        assertThat(SecondRule.getInstance().getRank())
                .isEqualTo(WinningLevel.SECOND);
    }

    @Test
    @DisplayName("[SecondRule.isMatched] 딱 5개 일치 and 보너스 번호 일치 -> 조건 만족 판정")
    public void matchSuccessTest() {
        Lotto lotto = Lotto.of(List.of(1,2,3,4,5,6));
        WinningNumber winningNumber = WinningNumber.of(List.of(10,2,3,4,5,6), 1);

        assertThat(SecondRule.getInstance().isMatched(lotto, winningNumber)).isTrue();
    }

    @Test
    @DisplayName("[ThirdRule.isMatched] 4개나 6개 일치 시 -> 조건 불만족 판정")
    public void matchFailTest() {
        Lotto lotto = Lotto.of(List.of(1,2,3,4,5,6));
        WinningNumber winningNumberMatch4 = WinningNumber.of(List.of(10,20,3,4,5,6), 17);
        WinningNumber winningNumberMatch6 = WinningNumber.of(List.of(1,2,3,4,5,6), 17);

        assertThat(SecondRule.getInstance().isMatched(lotto, winningNumberMatch4)).isFalse();
        assertThat(SecondRule.getInstance().isMatched(lotto, winningNumberMatch6)).isFalse();
    }

    @Test
    @DisplayName("[SecondRule.isMatched] 딱 5개 일치 and 보너스 번호 불일치 -> 조건 불만족 판정")
    public void matchFailWithBonusTest() {
        Lotto lotto = Lotto.of(List.of(1,2,3,4,5,6));
        WinningNumber winningNumber = WinningNumber.of(List.of(10,2,3,4,5,6), 25);

        assertThat(SecondRule.getInstance().isMatched(lotto, winningNumber)).isFalse();
    }
}