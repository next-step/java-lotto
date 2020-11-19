package lotto.domain.winning;

import lotto.domain.Lottos;
import lotto.domain.game.Lotto;
import lotto.domain.game.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created By mand2 on 2020-11-19.
 */
class WinningCheckerTest {

    Lottos lottos;

    @BeforeEach
    void setUp() {
        Lotto lotto1 = Lotto.of(LottoNumber.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto lotto2 = Lotto.of(LottoNumber.of(Arrays.asList(1, 2, 3, 14, 15, 16)));
        Lotto lotto3 = Lotto.of(LottoNumber.of(Arrays.asList(1, 2, 3, 24, 25, 26)));
        Lotto lotto4 = Lotto.of(LottoNumber.of(Arrays.asList(1, 2, 3, 34, 35, 36)));

        lottos = Lottos.of(Arrays.asList(lotto1, lotto2, lotto3, lotto4));
    }

    @ParameterizedTest
    @DisplayName("당첨번호와 내가 산 로또번호를 비교한다")
    @CsvSource(value = { "1, 42, 41, 42, 43, 44=1" }, delimiter = '=')
    void comapre_winningNumber_to_my_lotto(String inputWinning, int expected) {
        // given
        WinningNumber winningNumber = WinningNumber.of(inputWinning);

        // when
        lottos.checkWinningResult(winningNumber);

        // then
        for (Lotto lotto : lottos.list()) {
            assertThat(expected).isEqualTo(lotto.winningResult());
        }
    }


    @ParameterizedTest
    @DisplayName("당첨개수로 결과값을 찾는다.")
    @CsvSource(value = { "1, 2, 3, 42, 43, 44=5", "1, 42, 41, 42, 43, 44=6" }, delimiter = '=')
    void convert_winningResult_to_winning_rank(String inputWinning, int expectedRank) {
        // given
        WinningNumber winningNumber = WinningNumber.of(inputWinning);

        // when
        lottos.checkWinningResult(winningNumber);

        // then
        for (Lotto lotto : lottos.list()) {
            WinningRank winningRank = WinningRank.getWinningRank(lotto.winningResult());
            assertThat(expectedRank).isEqualTo(winningRank.getRank());
        }
    }


}
