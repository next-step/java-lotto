package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningNumberTest {
    @Test
    @DisplayName("[WinningNumber.of] 숫자 6개와 보너스 번호로 -> 당첨 번호 생성")
    public void createTest() {
        assertThat(WinningNumber.of(List.of(1,2,3,4,5,6), 10))
                .isEqualTo(WinningNumber.of(List.of(1,2,3,4,5,6), 10));
    }

    @Test
    @DisplayName("[WinningNumber.of] 순서 상관 없이 같은 숫자 목록에 보너스 번호마저 같으면 -> 같은 당첨 번호 취급")
    public void sameTest() {
        assertThat(WinningNumber.of(List.of(1,2,3,4,5,6), 10))
                .isEqualTo(WinningNumber.of(List.of(6,5,4,3,2,1), 10));
    }

    @Test
    @DisplayName("[WinningNumber.of] 숫자 목록이 같아도 보너스 번호가 다르면 -> 다른 당첨 번호 취급")
    public void notSameTest() {
        assertThat(WinningNumber.of(List.of(1,2,3,4,5,6), 10))
                .isNotEqualTo(WinningNumber.of(List.of(6,5,4,3,2,1), 11));
    }

    @Test
    @DisplayName("[WinningNumber.of] 숫자가 6개가 아니면 -> 예외 던짐")
    public void noSixTest() {
        assertThatIllegalArgumentException()
                .as("길이 5 테스트")
                .isThrownBy(() -> {
                    WinningNumber.of(List.of(1,2,3,4,5), 10);
                });

        assertThatIllegalArgumentException()
                .as("길이 7 테스트")
                .isThrownBy(() -> {
                    WinningNumber.of(List.of(1,2,3,4,5,6,7), 10);
                });
    }

    @Test
    @DisplayName("[WinningNumber.of] 숫자가 1 이상 45 이하를 벗어난 게 있다면 -> 예외 던짐")
    public void outOfIndexTest() {
        assertThatIllegalArgumentException()
                .as("45 초과 테스트")
                .isThrownBy(() -> {
                    WinningNumber.of(List.of(1,2,3,4,5,46), 15);
                });

        assertThatIllegalArgumentException()
                .as("1 미만 테스트")
                .isThrownBy(() -> {
                    WinningNumber.of(List.of(1,2,3,4,5,0), 15);
                });
    }

    @Test
    @DisplayName("[WinningNumber.of] 숫자 6개 중 보너스 번호와 중복되는 게 있으면 -> 예외 던짐")
    public void bonusDuplicaitonTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    WinningNumber.of(List.of(1,2,3,4,5,6), 5);
                });
    }
}
