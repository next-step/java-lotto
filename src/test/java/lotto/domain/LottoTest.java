package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    @Test
    void create() {
        Lotto lotto = new Lotto(Lotto.of(Arrays.asList(8, 21, 23, 41, 42, 44)));
    }

    @DisplayName("6개 아닐 경우 예외")
    @Test
    void invalidMaxSize() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(Lotto.of(Arrays.asList(8, 21, 23, 41, 42, 44, 44)));
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(Lotto.of(Arrays.asList(41, 42, 44, 44)));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 생성 번호 범위 조건 45보다 클 경우 예외 발생")
    @Test
    void invalidRange() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(Lotto.of(Arrays.asList(8, 21, 23, 41, 45, 46)));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 생성 번호 중복인 경우 예외 발생")
    @Test
    void invalidDuplicate() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(Lotto.of(Arrays.asList(8, 21, 21, 41, 45, 4)));
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("로또 번호 매칭")
    @Test
    void match() {
        Lotto lotto = new Lotto(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
        int count = lotto.match(Arrays.asList(1, 2, 9, 4, 5, 6));
        assertThat(count).isEqualTo(5);
    }

}
