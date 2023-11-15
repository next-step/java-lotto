package lotto;

import lotto.type.WinningLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningNumberTest {
    @Test
    @DisplayName("[WinningNumber.of] 숫자 6개로 -> 당첨 번호 생성")
    public void createTest() {
        assertThat(WinningNumber.of(List.of(1,2,3,4,5,6)))
                .isEqualTo(WinningNumber.of(List.of(1,2,3,4,5,6)));
    }

    @Test
    @DisplayName("[WinningNumber.of] 같은 숫자 목록이면 순서 상관 없이 -> 같은 당첨 번호 취급")
    public void sortingTest() {
        assertThat(WinningNumber.of(List.of(1,2,3,4,5,6)))
                .isEqualTo(WinningNumber.of(List.of(6,5,4,3,2,1)));
    }

    @Test
    @DisplayName("[WinningNumber.of] 숫자가 6개가 아니면 -> 예외 던짐")
    public void noSixTest() {
        assertThatIllegalArgumentException()
                .as("길이 5 테스트")
                .isThrownBy(() -> {
                    WinningNumber.of(List.of(1,2,3,4,5));
                });

        assertThatIllegalArgumentException()
                .as("길이 7 테스트")
                .isThrownBy(() -> {
                    WinningNumber.of(List.of(1,2,3,4,5,6,7));
                });
    }

    @Test
    @DisplayName("[WinningNumber.of] 숫자가 1 이상 45 이하를 벗어난 게 있다면 -> 예외 던짐")
    public void outOfIndexTest() {
        assertThatIllegalArgumentException()
                .as("45 초과 테스트")
                .isThrownBy(() -> {
                    WinningNumber.of(List.of(1,2,3,4,5,46));
                });

        assertThatIllegalArgumentException()
                .as("1 미만 테스트")
                .isThrownBy(() -> {
                    WinningNumber.of(List.of(1,2,3,4,5,0));
                });
    }

    @Test
    @DisplayName("[WinningNumber.whatRank] 2개 당첨 시 -> 꽝")
    public void noneRankTest() {
        Lotto lotto = Lotto.of(List.of(1,2,3,4,5,6));
        WinningNumber winningNumber = WinningNumber.of(List.of(1,2,13,14,15,16));

        assertThat(winningNumber.whatRank(lotto))
                .isEqualTo(WinningLevel.NONE);
    }

    @Test
    @DisplayName("[WinningNumber.whatRank] 3개 당첨 시 -> 5등")
    public void rank5Test() {
        Lotto lotto = Lotto.of(List.of(1,2,3,4,5,6));
        WinningNumber winningNumber = WinningNumber.of(List.of(1,2,3,14,15,16));

        assertThat(winningNumber.whatRank(lotto))
                .isEqualTo(WinningLevel.FIFTH);
    }

    @Test
    @DisplayName("[WinningNumber.whatRank] 4개 당첨 시 -> 4등")
    public void rank4Test() {
        Lotto lotto = Lotto.of(List.of(1,2,3,4,5,6));
        WinningNumber winningNumber = WinningNumber.of(List.of(1,2,3,4,15,16));

        assertThat(winningNumber.whatRank(lotto))
                .isEqualTo(WinningLevel.FOURTH);
    }

    @Test
    @DisplayName("[WinningNumber.whatRank] 5개 당첨 시 -> 3등")
    public void rank3Test() {
        Lotto lotto = Lotto.of(List.of(1,2,3,4,5,6));
        WinningNumber winningNumber = WinningNumber.of(List.of(1,2,3,4,5,16));

        assertThat(winningNumber.whatRank(lotto))
                .isEqualTo(WinningLevel.THIRD);
    }

    @Test
    @DisplayName("[WinningNumber.whatRank] 6개 당첨 시 -> 1등")
    public void rank1Test() {
        Lotto lotto = Lotto.of(List.of(1,2,3,4,5,6));
        WinningNumber winningNumber = WinningNumber.of(List.of(1,2,3,4,5,6));

        assertThat(winningNumber.whatRank(lotto))
                .isEqualTo(WinningLevel.FIRST);
    }
}
