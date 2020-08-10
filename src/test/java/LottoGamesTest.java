import domain.LottoGame;
import domain.LottoGames;
import domain.LottoMoney;
import domain.LottoWinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGamesTest {
    private LottoGames lottoGames;
    private LottoWinningNumbers lottoWinningNumbers;

    @BeforeEach
    void setUp() {
        List<LottoGame> games = new ArrayList<>();
        games.add(new LottoGame(new ArrayList<>(Arrays.asList(8, 21, 23, 41, 42, 43))));
        games.add(new LottoGame(new ArrayList<>(Arrays.asList(3, 5, 11, 16, 32, 38))));
        games.add(new LottoGame(new ArrayList<>(Arrays.asList(7, 11, 16, 35, 36, 44))));
        games.add(new LottoGame(new ArrayList<>(Arrays.asList(1, 8, 11, 31, 41, 42))));
        games.add(new LottoGame(new ArrayList<>(Arrays.asList(13, 14, 16, 38, 42, 45))));
        games.add(new LottoGame(new ArrayList<>(Arrays.asList(7, 11, 30, 40, 42, 43))));
        games.add(new LottoGame(new ArrayList<>(Arrays.asList(2, 13, 22, 32, 38, 45))));
        games.add(new LottoGame(new ArrayList<>(Arrays.asList(23, 25, 33, 36, 39, 41))));
        games.add(new LottoGame(new ArrayList<>(Arrays.asList(1, 3, 5, 14, 22, 45))));
        games.add(new LottoGame(new ArrayList<>(Arrays.asList(5, 9, 38, 41, 43, 44))));
        games.add(new LottoGame(new ArrayList<>(Arrays.asList(2, 8, 9, 18, 19, 21))));
        games.add(new LottoGame(new ArrayList<>(Arrays.asList(13, 14, 18, 21, 23, 35))));
        games.add(new LottoGame(new ArrayList<>(Arrays.asList(17, 21, 29, 37, 42, 45))));
        games.add(new LottoGame(new ArrayList<>(Arrays.asList(3, 8, 27, 30, 35, 44))));


        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        lottoGames = new LottoGames(games);
        lottoWinningNumbers = new LottoWinningNumbers(winningNumbers);
    }

    @ParameterizedTest
    @CsvSource(value = {"6=0", "5=0", "4=0", "3=1"}, delimiter = '=')
    @DisplayName("다수의 로또 게임과 당첨 번호를 비교해 3개 이상 6개 이하 일치하는 횟수를 구한다.")
    void lottoGamesTest(int key, int expected) {
        Map<Integer, Integer> result = lottoGames.getWinningStatistics(lottoWinningNumbers);

        assertThat(result.get(key)).isEqualTo(expected);
    }

    @Test
    @DisplayName("수익률을 구한다.")
    void getBenefitRateTest() {
        Map<Integer, Integer> winningStatistics = lottoGames.getWinningStatistics(lottoWinningNumbers);
        LottoMoney inputMoney = new LottoMoney(14000);

        double benefitRate = lottoGames.getBenefitRate(winningStatistics, inputMoney);
        String benefitRateStr = String.format("%.2f", benefitRate);
        assertThat(benefitRateStr).isEqualTo("0.36");
    }
}