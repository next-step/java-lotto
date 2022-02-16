package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName(value = "당첨 번호와 보너스 번호는 중복될 수 없다.")
    @Test
    void distinctWinningAndBonus() {
        Lottos lottos = new Lottos(new LottoPrice(10000));
        assertThatThrownBy(() -> new WinningLotto(new Lotto(new HashSet(Arrays.asList(1,2,3,4,5,6))), new LottoNumber(6), lottos))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
