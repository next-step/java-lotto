package lotto.rule;

import lotto.Lotto;
import lotto.WinningNumber;
import lotto.type.WinningLevel;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstRuleTest {
    @Test
    @DisplayName("[FirstRule.getRank] 호출 시 -> 1등 enum 반환")
    public void getCorrectRank() {
        assertThat(FirstRule.getInstance().getRank())
                .isEqualTo(WinningLevel.FIRST);
    }

    @Test
    @DisplayName("[FirstRule.isMatched] 6개 전부 일치 시 -> 조건 만족 판정")
    public void matchSuccessTest() {
        Lotto lotto = Lotto.of(List.of(1,2,3,4,5,6));
        WinningNumber winningNumber = WinningNumber.of(List.of(1,2,3,4,5,6));

        assertThat(FirstRule.getInstance().isMatched(lotto, winningNumber)).isTrue();
    }

    @Test
    @DisplayName("[FirstRule.isMatched] 5개만 일치 시 -> 조건 불만족 판정")
    public void matchFailTest() {
        Lotto lotto = Lotto.of(List.of(1,2,3,4,5,6));
        WinningNumber winningNumber = WinningNumber.of(List.of(10,2,3,4,5,6));

        assertThat(FirstRule.getInstance().isMatched(lotto, winningNumber)).isFalse();
    }
}