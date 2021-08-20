package lotto.domain;

import lotto.exception.InputError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {

    @DisplayName("null 또는 size 가 0 일 때, 로또리스트 생성 에러")
    @Test
    void createError() {
        assertThatThrownBy(() -> new Lottos(null))
                .isInstanceOf(InputError.class);
        assertThatThrownBy(() -> new Lottos(new ArrayList<>()))
                .isInstanceOf(InputError.class);
    }

    @DisplayName("로또들 생성하면 로또 리스트가 반환된다.")
    @Test
    void create() {
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 20, 23, 35))));
        assertThat(lottos.values()).contains(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(lottos.values()).contains(new Lotto(Arrays.asList(7, 8, 9, 20, 23, 35)));
    }
}