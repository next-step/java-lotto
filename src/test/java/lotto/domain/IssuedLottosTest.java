package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class IssuedLottosTest {

    @Test
    void name() {
        IssuedLottos issuedLottos = new IssuedLottos(
                Arrays.asList(
                        new Lotto(Arrays.asList(1, 2, 3, 40, 41, 42)),
                        new Lotto(Arrays.asList(1, 2, 3, 4, 40, 41)),
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 40)),
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15))
                )
        );

        issuedLottos.checkNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(issuedLottos.countWin(3)).isEqualTo(1);
        assertThat(issuedLottos.countWin(4)).isEqualTo(1);
        assertThat(issuedLottos.countWin(5)).isEqualTo(1);
        assertThat(issuedLottos.countWin(6)).isEqualTo(1);
    }
}
