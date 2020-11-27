package lotto.domain.winning;

import lotto.domain.game.Lotto;
import lotto.domain.game.LottoNumber;
import lotto.domain.game.LottoNumberSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.stream.Collectors;

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

    @org.junit.jupiter.api.Test
    @DisplayName("2등이 되었다")
    void became_second_place() {
        // given
        Lotto lotto = Lotto.of(LottoNumberSet.of(
                Arrays.asList(1, 2, 3, 4, 5, 7).stream()
                        .map(LottoNumber::from)
                        .collect(Collectors.toList())));

        // when
        WinningRank winningRank = winningNumber.match(lotto);

        // then
        assertThat(winningRank).isEqualTo(WinningRank.SECOND);
    }


}
