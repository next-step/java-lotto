package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("6개 초과 들어갔을때")
    @Test
    void throwIllegalArgumentException1_1() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,6,7")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6개 미만 들어갔을때")
    @Test
    void throwIllegalArgumentException1_2() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복 숫자가 들어갔을 때")
    @Test
    void throwIllegalArgumentException1_3() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,5")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 미만 숫자가 들어갔을때")
    @Test
    void throwIllegalArgumentException2_1() {
        assertThatThrownBy(() -> new Lotto("0,1,2,3,4,5")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("45 초과 숫자가 들어갔을때")
    @Test
    void throwIllegalArgumentException2_2() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,46")).isInstanceOf(IllegalArgumentException.class);
    }


}
