package LottoTest;

import lotto.domain.LottoGame;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.assertj.core.api.Assertions.*;

public class WinningNumberTest {
    @Test
    void Given_LottoGame_When_MatchCount_Then_ReturnMatchCount() {
        LottoGame lottoGame = new LottoGame(Arrays.asList(1,2,3,4,5,6));
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1,2,3,4,5,6));

        int matchCount =  winningNumber.matchCount(lottoGame);
        assertThat(matchCount).isEqualTo(6);
    }
}
