package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    private Lottos lottos;
    private Lotto winningLotto;

    @BeforeEach
    void setUp() {
        lottos = Lottos.of(List.of(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)), Lotto.of(Arrays.asList(2, 3, 4, 5, 6, 7))));
        winningLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName(value = "Lottos of 메소드 검사")
    void test1() {
        assertThat(lottos).isEqualTo(new Lottos(Arrays.asList(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)), Lotto.of(Arrays.asList(2, 3, 4, 5, 6, 7)))));
    }

    @Test
    @DisplayName(value = "당첨 번호와 보너스 번호가 일치할 경우 검사")
    void test2() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottos.getLottoResult(winningLotto, 6);
        });
    }
}
