package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoNumbersTest {

    @DisplayName("보너스 숫자가 당첨번호와 같을때")
    @Test
    void throwIllegalArgumentException3() {
        assertThatThrownBy(() -> new WinningLottoNumbers(new Lotto("1,2,3,4,5,6"), 6)).isInstanceOf(IllegalArgumentException.class);
    }
}
