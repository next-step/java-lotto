package lotto.domain;

import org.junit.jupiter.api.Assertions;
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

    @Test
    @DisplayName("winningLotto 의 번호와 얼마나 일치하는지 결과를 보여줘야 한다.")
    void getResult() {
        lottos.add(LottoFactory.createLotto("1, 2, 3, 4, 5, 6"));
        lottos.add(LottoFactory.createLotto("1, 2, 3, 4, 5, 7"));
        lottos.add(LottoFactory.createLotto("2, 3, 4, 5, 6, 7"));
        lottos.add(LottoFactory.createLotto("3, 4, 5, 6, 7, 8"));
        lottos.add(LottoFactory.createLotto("4, 5, 6, 7, 8, 9"));

        Lotto winningLotto = LottoFactory.createLotto("1, 2, 3, 4, 5, 6");
        Result result = lottos.getResult(winningLotto);
        Assertions.assertAll(
                () -> assertThat(result.getNumOfLotto(Jackpot.THREE))
                        .isEqualTo(1),
                () -> assertThat(result.getNumOfLotto(Jackpot.FOUR))
                        .isEqualTo(1),
                () -> assertThat(result.getNumOfLotto(Jackpot.FIVE))
                        .isEqualTo(2),
                () -> assertThat(result.getNumOfLotto(Jackpot.SIX))
                        .isEqualTo(1)
        );
    }
}
