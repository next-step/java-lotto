package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    @Test
    @DisplayName("번호 개수 확인")
    void number() {
        String number = "1, 2, 3, 4, 5, 6, 7";
        assertThatThrownBy(() -> {
            new Lotto(number);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("개수가 6개가 아닙니다.");
    }

    @Test
    @DisplayName("로또 번호 확인")
    void element() {
        String number = "-1, 2, 3, 4, 5, 6";
        assertThatThrownBy(() -> {
            new Lotto(number);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("음수는 로또 번호가 될 수 없습니다.");
    }
}
