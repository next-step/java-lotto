package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.type.RewardPrice;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardPriceTest {

  @ParameterizedTest
  @MethodSource("matchCountTestCases")
  @DisplayName("지난 주 당첨 번호 기준, 일치하는 숫자 갯수 구하는 기능")
  void rewardAmountTest(List<Integer> given, int expected) {
    WinningNumbers winningNumbers = WinningNumbers.of(List.of(1, 2, 3, 4, 5, 6), 7);
    LottoTicket myLottoTicket = LottoTicket.generate(given);
    assertThat(winningNumbers.matchNumberCount(myLottoTicket)).isEqualTo(expected);
  }

  @ParameterizedTest
  @MethodSource("rewardAmountTestCases")
  @DisplayName("당첨 번호 갯수별 금액 관리 기능")
  void rewardAmountTest2(List<Integer> given, int expected) {
    WinningNumbers winningNumbers = WinningNumbers.of(List.of(1, 2, 3, 4, 5, 6), 7);
    LottoTicket myLottoTicket = LottoTicket.generate(given);
    int count = winningNumbers.matchNumberCount(myLottoTicket);

    assertThat(RewardPrice.rewardBy(count, Boolean.FALSE)).isEqualTo(expected);
  }

  private static Stream<Arguments> matchCountTestCases() {
    return Stream.of(
        Arguments.of(List.of(1, 20, 30, 40, 7, 8), 1),
        Arguments.of(List.of(10, 20, 3, 4, 5, 6), 4),
        Arguments.of(List.of(10, 2, 3, 4, 5, 6), 5),
        Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6)
    );
  }

  private static Stream<Arguments> rewardAmountTestCases() {
    return Stream.of(
        Arguments.of(List.of(1, 20, 30, 40, 7, 8), 0),
        Arguments.of(List.of(10, 20, 30, 4, 5, 6), 5000),
        Arguments.of(List.of(10, 20, 3, 4, 5, 6), 50000),
        Arguments.of(List.of(10, 2, 3, 4, 5, 6), 1500000),
        Arguments.of(List.of(1, 2, 3, 4, 5, 6), 2000000000)
    );
  }
}
