package study.lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import study.lottogame.factory.LotteryFactory;

public class LotteriesTest {

  @DisplayName("당첨 번호와 비교하여 각 로또의 순위를 결정하여 게임 결과를 반환한다.")
  @ParameterizedTest
  @MethodSource("createTestLottery")
  public void calculateGameResult(String[] numbers, Rank rank) {
    Lotteries lotteries = new Lotteries(List.of(LotteryFactory.create(numbers)));
    Lottery prizeLottery = LotteryFactory.create(new String[]{"1", "2", "3", "4", "5", "6"});
    LottoNumber bonusLottoNumber = LottoNumber.valueOf(7);

    GameResult gameResult = lotteries
        .calculateGameResult(new WinningLottery(prizeLottery, bonusLottoNumber));

    Map<Rank, Integer> prizeStaticsMap = gameResult.getPrizeStaticsMap();
    assertThat(prizeStaticsMap.get(rank)).isEqualTo(1);
    assertThat(gameResult.getPrizeMoney()).isEqualTo(new Money(rank.getWinningMoney()));
  }

  public static Stream<Arguments> createTestLottery() {
    return Stream.of(
        Arguments.of(new String[]{"1", "2", "3", "4", "5", "6"}, Rank.FIRST),
        Arguments.of(new String[]{"1", "2", "3", "4", "5", "7"}, Rank.SECOND),
        Arguments.of(new String[]{"1", "2", "3", "4", "5", "8"}, Rank.THIRD),
        Arguments.of(new String[]{"1", "2", "3", "4", "7", "8"}, Rank.FOURTH),
        Arguments.of(new String[]{"1", "2", "3", "7", "8", "9"}, Rank.FIFTH),
        Arguments.of(new String[]{"1", "11", "12", "13", "14", "15"}, Rank.MISS)
    );
  }
}
