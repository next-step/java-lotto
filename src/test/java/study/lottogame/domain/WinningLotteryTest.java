package study.lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import study.lottogame.factory.LotteryFactory;

public class WinningLotteryTest {

  @DisplayName("bonus 로또넘버는 당첨로또의 로또넘버들과 중복되면 Exception을 던진다.")
  @Test
  public void WinningLottery_throwsException_duplicatedNumber() {
    Lottery prizeLottery = LotteryFactory.create(new String[]{"1", "2", "3", "4", "5", "6"});
    LottoNumber bonusLottoNumber = LottoNumber.valueOf(1);

    assertThatThrownBy(() -> new WinningLottery(prizeLottery, bonusLottoNumber))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("Rank를 계산한다.")
  @ParameterizedTest
  @MethodSource("createTestLottery")
  public void getRank(String[] numbers, Rank rank) {
    Lottery prizeLottery = LotteryFactory.create(new String[]{"1", "2", "3", "4", "5", "6"});
    LottoNumber bonusLottoNumber = LottoNumber.valueOf(7);
    WinningLottery winningLottery = new WinningLottery(prizeLottery, bonusLottoNumber);
    Lottery lottery = LotteryFactory.create(numbers);

    assertThat(winningLottery.getRank(lottery)).isEqualTo(rank);
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
