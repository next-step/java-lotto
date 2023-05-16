package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    @Test
    @DisplayName(value = "Lottos of 메소드 검사")
    void test1() {
        Lottos lottos = Lottos.of(List.of(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)), Lotto.of(Arrays.asList(2, 3, 4, 5, 6, 7))));

        assertThat(lottos).isEqualTo(new Lottos(Arrays.asList(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)), Lotto.of(Arrays.asList(2, 3, 4, 5, 6, 7)))));
    }
}
