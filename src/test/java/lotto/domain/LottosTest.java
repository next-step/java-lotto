package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    Lottos lottos;

    @BeforeEach
    void setUp() {
        lottos = new Lottos();
    }

    @Test
    @DisplayName("Lotto 를 add 를 통해 추가 할 수 있다.")
    void add() {
        lottos.add(LottoFactory.createLotto("1, 2, 3, 4, 5, 6"));
        lottos.add(LottoFactory.createLotto("8, 21, 23, 41, 42, 43"));
        lottos.add(LottoFactory.createLotto("3, 5, 11, 16, 32, 38"));
        lottos.add(LottoFactory.createLotto("7, 11, 16, 35, 36, 44"));
        assertThat(lottos.toString()).isEqualTo(
                "[1, 2, 3, 4, 5, 6]\n"
                        + "[8, 21, 23, 41, 42, 43]\n"
                        + "[3, 5, 11, 16, 32, 38]\n"
                        + "[7, 11, 16, 35, 36, 44]\n"
        );
    }
}
