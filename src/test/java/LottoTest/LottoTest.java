package LottoTest;

import lotto.Lotto;
import lotto.LottoGame;
import lotto.LottoResult;
import lotto.WinningNumber;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class LottoTest {
    @Test
    void Given_LottoGame_When_Net_Then_NoException() {
        //given
        List<LottoGame> lottoGame = Arrays.asList(
                new LottoGame(Arrays.asList(1, 2, 3, 4, 5, 6))
        );

        //when then
        assertDoesNotThrow(() -> new Lotto(lottoGame));
    }

    @Test
    void Given_WinningNumbers_When_Match_Then_LottoResult() {
        //given
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<LottoGame> lottoGames = Arrays.asList(
                new LottoGame(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoGame(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new LottoGame(Arrays.asList(1, 2, 3, 4, 8, 7)),
                new LottoGame(Arrays.asList(1, 2, 3, 9, 8, 7)),
                new LottoGame(Arrays.asList(1, 2, 10, 9, 8, 7)),
                new LottoGame(Arrays.asList(1, 11, 10, 9, 8, 7)),
                new LottoGame(Arrays.asList(12, 11, 10, 9, 8, 7))
        );

        Lotto lotto = new Lotto(lottoGames);

        //when
        LottoResult result = lotto.result(winningNumber);

        //then
        assertThat(result.winningNumberCount(0)).isEqualTo(1);
        assertThat(result.winningNumberCount(1)).isEqualTo(1);
        assertThat(result.winningNumberCount(2)).isEqualTo(1);
        assertThat(result.winningNumberCount(3)).isEqualTo(1);
        assertThat(result.winningNumberCount(4)).isEqualTo(1);
        assertThat(result.winningNumberCount(5)).isEqualTo(1);
        assertThat(result.winningNumberCount(6)).isEqualTo(1);
    }
}
