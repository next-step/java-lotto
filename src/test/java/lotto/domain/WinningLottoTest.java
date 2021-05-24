package lotto.domain;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningLottoTest {

    @DisplayName("로또에 사용되는 6개의 번호와 1개의 보너스 번호는 모두 달라야 한다.")
    @Test
    void duplicateBonusNumberTest() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> WinningLotto.of(Arrays.asList(1, 2, 3, 4, 5, 6), 1));
    }
}
