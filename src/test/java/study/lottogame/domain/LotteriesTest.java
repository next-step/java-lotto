package study.lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lottogame.util.LottoNumbersGenerator;

public class LotteriesTest {

  @DisplayName("당첨 번호와 비교하여 각 로또의 순위를 결정하고, 각 순위에 해당하는 로또 개수를 세서 Map으로 반환한다.")
  @Test
  public void getWinningCountsByRank(){
    Lottery lottery1 = new Lottery(LottoNumbersGenerator
        .generate(new String[]{"1", "2", "3", "4", "5", "6"}));
    Lottery lottery2 = new Lottery(LottoNumbersGenerator
        .generate(new String[]{"4", "5", "6", "7", "8", "9"}));
    Lottery lottery3 = new Lottery(LottoNumbersGenerator
        .generate(new String[]{"1", "11", "12", "13", "14", "15"}));
    Lotteries lotteries = new Lotteries(Arrays.asList(lottery1, lottery2, lottery3));
    Lottery winningLottery = new Lottery(LottoNumbersGenerator
        .generate(new String[]{"1", "2", "3", "4", "5", "6"}));

    Map<Rank, Integer> rankToLottoCountMap = lotteries
        .getWinningCountsByRank(winningLottery);

    assertThat(rankToLottoCountMap.get(Rank.MISS)).isEqualTo(1);
    assertThat(rankToLottoCountMap.get(Rank.FOURTH)).isEqualTo(1);
    assertThat(rankToLottoCountMap.get(Rank.FIRST)).isEqualTo(1);
  }
}
