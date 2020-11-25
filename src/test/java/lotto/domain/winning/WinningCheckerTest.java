package lotto.domain.winning;

import lotto.domain.game.Lotto;
import lotto.domain.game.LottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created By mand2 on 2020-11-25.
 */
class WinningCheckerTest {

    WinningNumber winningNumber;

    @BeforeEach
    void setUp() {
        winningNumber = WinningNumber.of("1, 2, 3, 4, 5, 6", "7");
    }

    @Test
    @DisplayName("2등이 되었다")
    void became_second_place() {
        // given
        Lotto lotto = Lotto.of(LottoNumber.of(Arrays.asList(1, 2, 3, 4, 5, 7)));

        // when
        WinningRank winningRank = winningNumber.match(lotto);

        // then
        assertThat(winningRank).isEqualTo(WinningRank.SECOND);
    }


}
