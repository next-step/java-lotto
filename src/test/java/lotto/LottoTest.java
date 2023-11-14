package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    @Test
    @DisplayName("[Lotto.of] 숫자 6개로 -> 로또 생성")
    public void createTest() {
        assertThat(Lotto.of(List.of(1,2,3,4,5,6)))
                .isEqualTo(Lotto.of(List.of(1,2,3,4,5,6)));
    }

    @Test
    @DisplayName("[Lotto.of] 같은 숫자 목록이면 순서 상관 없이 -> 같은 로또 취급")
    public void sortingTest() {
        assertThat(Lotto.of(List.of(1,2,3,4,5,6)))
                .isEqualTo(Lotto.of(List.of(6,5,4,3,2,1)));
    }

    @Test
    @DisplayName("[Lotto.of] 숫자가 6개가 아니면 -> 예외 던짐")
    public void noSixTest() {
        assertThatIllegalArgumentException()
                .as("길이 5 테스트")
                .isThrownBy(() -> {
                    Lotto.of(List.of(1,2,3,4,5));
                });

        assertThatIllegalArgumentException()
                .as("길이 7 테스트")
                .isThrownBy(() -> {
                    Lotto.of(List.of(1,2,3,4,5,6,7));
                });
    }

    @Test
    @DisplayName("[Lotto.of] 숫자가 1 이상 45 이하를 벗어난 게 있다면 -> 예외 던짐")
    public void outOfIndexTest() {
        assertThatIllegalArgumentException()
                .as("45 초과 테스트")
                .isThrownBy(() -> {
                    Lotto.of(List.of(1,2,3,4,5,46));
                });

        assertThatIllegalArgumentException()
                .as("1 미만 테스트")
                .isThrownBy(() -> {
                    Lotto.of(List.of(1,2,3,4,5,0));
                });
    }
}
