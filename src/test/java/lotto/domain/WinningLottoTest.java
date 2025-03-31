package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningLottoTest {
    @DisplayName("당첨 로또 생성하면서 보너스 번호가 당첨 번호와 겹치는지 검사")
    @Test
    void create_winning_lotto() {
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningLotto(Lotto.createManually(Arrays.asList(45, 5, 4, 3, 2, 1)), new LottoNumber(45)));
    }
}
