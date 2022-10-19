package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    void 당첨번호와_보너스번호는_중복_불가() {
        assertThatThrownBy(() -> WinningLotto.of(List.of(1, 2, 3, 4, 5, 6), 6))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
