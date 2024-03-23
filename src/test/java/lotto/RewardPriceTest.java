package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.WinningNumbers;
import lotto.domain.type.RewardPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardPriceTest {

  @ParameterizedTest
  @MethodSource("matchCountTestCases")
  @DisplayName("지난 주 당첨 번호 기준, 일치하는 숫자 갯수 구하는 기능")
  void rewardAmountTest(Set<Integer> given, int expected) {
    WinningNumbers winningNumbers = WinningNumbers.of(Set.of(1, 2, 3, 4, 5, 6), 7);
    LottoTicket myLottoTicket = LottoTicket.generate(given);
    assertThat(winningNumbers.matchNumberCount(myLottoTicket)).isEqualTo(expected);
  }

  @ParameterizedTest
  @MethodSource("rewardAmountTestCases")
  @DisplayName("당첨 번호 갯수별 금액 관리 기능")
  void rewardAmountTest2(Set<Integer> given, int expected) {
    WinningNumbers winningNumbers = WinningNumbers.of(Set.of(1, 2, 3, 4, 5, 6), 7);
    LottoTicket myLottoTicket = LottoTicket.generate(given);

    int count = winningNumbers.matchNumberCount(myLottoTicket);
    RewardPrice rewardPrice = RewardPrice.match(count, false);

    assertThat(rewardPrice.rewardAmount()).isEqualTo(expected);
  }

  @Test
  @DisplayName("5개 매칭, 보너스볼 매칭 안된 경우")
  void rewardAmountTest3() {
    WinningNumbers winningNumbers = WinningNumbers.of(Set.of(1, 2, 3, 4, 5, 6), 7);
    LottoTicket myLottoTicket = LottoTicket.generate(Set.of(1, 2, 3, 4, 5, 11));

    int count = winningNumbers.matchNumberCount(myLottoTicket);
    RewardPrice rewardPrice = RewardPrice.match(count, false);

    assertThat(rewardPrice.rewardAmount()).isEqualTo(1_500_000);
  }

  @Test
  @DisplayName("5개 매칭, 보너스볼 매칭 된 경우")
  void rewardAmountTest4() {
    WinningNumbers winningNumbers = WinningNumbers.of(Set.of(1, 2, 3, 4, 5, 6), 7);
    LottoTicket myLottoTicket = LottoTicket.generate(Set.of(1, 2, 3, 4, 5, 7));

    int count = winningNumbers.matchNumberCount(myLottoTicket);
    RewardPrice rewardPrice = RewardPrice.match(count, true);

    assertThat(rewardPrice.rewardAmount()).isEqualTo(30_000_000);
  }

  private static Stream<Arguments> matchCountTestCases() {
    return Stream.of(
        Arguments.of(Set.of(1, 20, 30, 40, 7, 8), 1),
        Arguments.of(Set.of(10, 20, 3, 4, 5, 6), 4),
        Arguments.of(Set.of(10, 2, 3, 4, 5, 6), 5),
        Arguments.of(Set.of(1, 2, 3, 4, 5, 6), 6)
    );
  }

  private static Stream<Arguments> rewardAmountTestCases() {
    return Stream.of(
        Arguments.of(Set.of(1, 20, 30, 40, 7, 8), 0),
        Arguments.of(Set.of(10, 20, 30, 4, 5, 6), 5_000),
        Arguments.of(Set.of(10, 20, 3, 4, 5, 6), 50_000),
        Arguments.of(Set.of(10, 2, 3, 4, 5, 6), 1_500_000),
        Arguments.of(Set.of(1, 2, 3, 4, 5, 6), 2_000_000_000)
    );
  }
}
