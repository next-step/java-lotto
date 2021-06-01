package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("1부터 45 까지의 숫자가 아닐 경우 예외 발생")
    @Test
    void invalidNumbers() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 48)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("서로 중복된 숫자일 경우 예외 발생")
    @Test
    void duplicateNumbers() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 1, 1, 1, 1, 1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}