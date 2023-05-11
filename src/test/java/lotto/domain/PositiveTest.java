package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PositiveTest {
    @Test
    @DisplayName("수동 로또 장수가 음수일 경우")
    void manualLottoNegative() {
        assertThatThrownBy(() -> {
            new Positive(-1);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("음수일 수 없습니다.");
    }

    @Test
    @DisplayName("숫자 비교")
    void equals() {
        Positive positive = new Positive(1);

        assertThat(positive.isEqual(1)).isTrue();
        assertThat(positive.isEqual(2)).isFalse();
    }
}
