package lotto.domain;

import static lotto.domain.model.Rank.FAILURE;
import static lotto.domain.model.Rank.FIFTH;
import static lotto.domain.model.Rank.FIRST;
import static lotto.domain.model.Rank.FOURTH;
import static lotto.domain.model.Rank.SECOND;
import static lotto.domain.model.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGamesTest {

  @DisplayName("Test to calculate the rank properly")
  @Test
  public void getRanksTest() {
    LottoGame firstPlace = new LottoGame(new HashSet<>(Arrays.asList(1,2,3,4,5,6)));
    LottoGame secondPlace = new LottoGame(new HashSet<>(Arrays.asList(1,2,3,4,5,7)));
    LottoGame thirdPlace = new LottoGame(new HashSet<>(Arrays.asList(1,2,3,4,5,8)));
    LottoGame fourthPlace = new LottoGame(new HashSet<>(Arrays.asList(1,2,3,4,7,8)));
    LottoGame fifthPlace = new LottoGame(new HashSet<>(Arrays.asList(1,2,3,7,8,9)));
    LottoGame failure = new LottoGame(new HashSet<>(Arrays.asList(1,2,7,8,9,10)));
    List<LottoGame> lottoNumbers = Arrays.asList(
        firstPlace,
        secondPlace,
        thirdPlace,
        fourthPlace,
        fifthPlace,
        failure
    );
    LottoGames lotto = new LottoGames(6000, lottoNumbers);
    WinningBalls winningBalls = new WinningBalls(new HashSet<>(Arrays.asList(1,2,3,4,5,6)), 7);

    WinningResult winningResult = lotto.confirmResult(winningBalls);
    RankStatistic rankStatistic = winningResult.deriveStatistics();

    assertThat(rankStatistic.countWinsOf(FIRST)).isEqualTo(1);
    assertThat(rankStatistic.countWinsOf(SECOND)).isEqualTo(1);
    assertThat(rankStatistic.countWinsOf(THIRD)).isEqualTo(1);
    assertThat(rankStatistic.countWinsOf(FOURTH)).isEqualTo(1);
    assertThat(rankStatistic.countWinsOf(FIFTH)).isEqualTo(1);
    assertThat(rankStatistic.countWinsOf(FAILURE)).isEqualTo(1);
  }}
