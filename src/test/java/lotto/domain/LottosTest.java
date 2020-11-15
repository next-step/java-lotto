package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("Lotto 를 Supplier 를 통해 create  할 수 있다.")
    void create() {
        Lottos lottos = Lottos.create(3, () -> new Lotto(Arrays.asList(
                1, 2, 3, 4, 5, 6
        )));
        assertThat(lottos.toString()).isEqualTo(
                "[1, 2, 3, 4, 5, 6]\n"
                        + "[1, 2, 3, 4, 5, 6]\n"
                        + "[1, 2, 3, 4, 5, 6]\n"
        );
    }

    @Test
    @DisplayName("winningLotto 의 번호와 얼마나 일치하는지 결과를 보여줘야 한다.")
    void getResult() {
        Lottos lottos = Lottos.create(0, () -> new Lotto(Arrays.asList(
                7, 8, 9, 10, 11, 12
        )));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)));
        lottos.add(new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8)));
        lottos.add(new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)));

        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
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
