package LottoTest;

import lotto.domain.LottoGame;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinningNumberTest {
    @Test
    @DisplayName("당첨번호와 로또게임에서 일치하는 번호를 계산하는 테스트")
    void Given_LottoGame_When_MatchCount_Then_ReturnMatchCount() {
        LottoGame lottoGame = new LottoGame(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6));

        int matchCount = winningNumber.matchCount(lottoGame);
        assertThat(matchCount).isEqualTo(6);
    }

    @Test
    @DisplayName("잘못된 당첨번호 테스트")
    void Given_WrongWinningNumber_When_New_Than_Exeption() {
        List<Integer> wrongWinningNumber = Arrays.asList(1, 2, 3, 4, 5, 100);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningNumber(wrongWinningNumber, 1, 45));
    }
}
