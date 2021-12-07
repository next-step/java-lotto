package lotto;

import lotto.game.Game;
import lotto.game.LottoNumbers;
import lotto.game.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    @Test
    @DisplayName("1등 테스트 - 6개의 숫자 모두 일치")
    void firstWin() {
        winTest(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6), Rank.FIRST_WIN);
    }

    @Test
    @DisplayName("2등 테스트 - 5개의 숫자 일치")
    void secondWin() {
        winTest(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 7), Rank.SECOND_WIN);
    }

    @Test
    @DisplayName("3등 테스트 - 4개의 숫자 일치")
    void thirdWin() {
        winTest(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 7, 8), Rank.THIRD_WIN);
    }

    @Test
    @DisplayName("4등 테스트 - 3개의 숫자 일치")
    void forthWin() {
        winTest(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 7, 8, 9), Rank.FORTH_WIN);
    }

    @Test
    @DisplayName("꼴등 테스트 - 2개 이하의 숫자 일치")
    void lose() {
        winTest(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 7, 8, 9, 10), Rank.LOSE);
    }

    private void winTest(List<Integer> gameNumbers, List<Integer> winNumbers, Rank result) {
        Game game = new Game(LottoNumbers.generate(gameNumbers));
        Rank rank = game.win(LottoNumbers.generate(winNumbers));
        assertThat(rank).isEqualTo(result);
    }

    @Test
    void toStringTest() {
        Game game = new Game(LottoNumbers.generate(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(game.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
