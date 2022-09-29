package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    void shouldValidateLotto() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 1, 1, 1, 1, 1, 1))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldReturnMatchedCount() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).getMatchedCount(new Lotto(List.of(1, 2, 3, 4, 5, 6)))).isEqualTo(6);
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).getMatchedCount(new Lotto(List.of(1, 2, 3, 4, 5, 7)))).isEqualTo(5);
        assertThat(new Lotto(List.of(1, 2, 3, 4,99,99)).getMatchedCount(new Lotto(List.of(1, 2, 3, 4, 8, 9)))).isEqualTo(4);
    }
}
