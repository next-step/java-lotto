package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    void getBonusWinningResult() {
        WinningLotto winningLotto = WinningLotto.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                LottoBall.from(10)
        );
        assertThat(
                        winningLotto.retrieveWinnerResult(new Lotto(List.of(1, 2, 3, 4, 5, 10))))
                .isEqualTo(new WinningResult(5, true));
    }

    @Test
    void getSecondWinningResult() {
        WinningLotto winningLotto = WinningLotto.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                LottoBall.from(10)
        );
        assertThat(
                winningLotto.retrieveWinnerResult(
                        new Lotto(List.of(1, 2, 3, 4, 5, 7))
                ))
                .isEqualTo(new WinningResult(5, false));
    }
}