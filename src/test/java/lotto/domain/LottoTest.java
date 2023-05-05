package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
    void lessThanZero() {
        String number = "-1, 2, 3, 4, 5, 6";
        assertThatThrownBy(() -> {
            new Lotto(number);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("1보다 작은 값은 로또 번호가 될 수 없습니다.");
    }
    @Test
    @DisplayName("로또 번호 확인")
    void moreThan45() {
        String number = "45, 47, 3, 4, 5, 6";
        assertThatThrownBy(() -> {
            new Lotto(number);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("로또 번호는 45를 넘어갈 수 없습니다.");
    }

    @Test
    @DisplayName("일치 개수")
    void match() {
        Lotto lotto1 = new Lotto("1, 2, 3, 4, 5, 6");
        Lotto lotto2 = new Lotto("22, 43, 15, 8, 9, 19");

        assertThat(lotto1.matchesNumber(lotto2)).isEqualTo(0);
    }
}
