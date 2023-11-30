package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    @Test
    @DisplayName("로또 번호는 6개만 선택해야한다.")
    void lotto1() {
        assertThatThrownBy(() -> {
            new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또번호는 6개를 선택해야 합니다");
    }

    @Test
    @DisplayName("로또 번호 6개는 중복을 허용하지 않는다.")
    void lotto2() {
        assertThatThrownBy(() -> {
            new LottoNumbers(Arrays.asList(1, 1, 3, 4, 5, 6));
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또번호는 중복이 불가능합니다.");
    }

}