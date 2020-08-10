import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGamesTest {
    private List<LottoGame> games;
    private List<Integer> winningNumbers;

    @BeforeEach
    void setUp() {
        games = new ArrayList<>();
        games.add(new LottoGame(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)))); // 6개 일치
        games.add(new LottoGame(new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7)))); // 5개 일치
        games.add(new LottoGame(new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7, 8)))); // 4개 일치
        games.add(new LottoGame(new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8, 9)))); // 3개 일치
        games.add(new LottoGame(new ArrayList<>(Arrays.asList(2, 3, 4, 7, 8, 9)))); // 3개 일치
        games.add(new LottoGame(new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9, 10)))); // 2개 일치

        winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest
    @CsvSource(value = {"6=1", "5=1", "4=1", "3=2"}, delimiter = '=')
    @DisplayName("다수의 로또 게임과 당첨 번호를 비교해 3개 이상 6개 이하 일치하는 횟수를 구한다.")
    void lottoGamesTest(int key, int expected) {
        LottoGames lottoGames = new LottoGames(games);
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumbers);
        Map<Integer, Integer> result = lottoGames.getWinningStatistics(lottoWinningNumbers);

        assertThat(result.get(key)).isEqualTo(expected);
    }

}