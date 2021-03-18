package LottoTest;

import lotto.*;
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
                new LottoGame(Arrays.asList(7, 2, 3, 4, 5, 6)),
                new LottoGame(Arrays.asList(7, 8, 3, 4, 5, 6)),
                new LottoGame(Arrays.asList(7, 8, 9, 4, 5, 6)),
                new LottoGame(Arrays.asList(7, 8, 9, 10, 5, 6)),
                new LottoGame(Arrays.asList(7, 8, 9, 10, 11, 6))
        );

        Lotto lotto = new Lotto(lottoGames);

        //when
        List<LottoGameResult> result = lotto.result(winningNumber);

        //then
        assertThat(result).contains(new LottoGameResult(6));
        assertThat(result).contains(new LottoGameResult(5));
        assertThat(result).contains(new LottoGameResult(4));
        assertThat(result).contains(new LottoGameResult(3));
        assertThat(result).contains(new LottoGameResult(2));
        assertThat(result).contains(new LottoGameResult(1));

        assertFalse(result.contains(new LottoGameResult(0)));
    }
}
