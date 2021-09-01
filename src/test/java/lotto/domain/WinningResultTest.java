package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningResultTest {

  @Test
  @DisplayName("수익률 확인 테스트")
  void getRateOfReturn() {
    //given
    int[] winningNumbers = {1, 2, 3, 4, 5, 6};
    int bonusNumber = 7;
    WinningInfo winningInfo = new WinningInfo(winningNumbers, bonusNumber);

    List<Lotto> lottos = Arrays.asList(
        Lotto.issueByManual(Arrays.asList(8, 21, 23, 41, 42, 43)),
        Lotto.issueByManual(Arrays.asList(3, 5, 11, 16, 32, 38)),
        Lotto.issueByManual(Arrays.asList(7, 11, 16, 35, 36, 44)),
        Lotto.issueByManual(Arrays.asList(1, 8, 11, 31, 41, 42)),
        Lotto.issueByManual(Arrays.asList(13, 14, 16, 38, 42, 45)),
        Lotto.issueByManual(Arrays.asList(7, 11, 30, 40, 42, 43)),
        Lotto.issueByManual(Arrays.asList(2, 13, 22, 32, 38, 45)),
        Lotto.issueByManual(Arrays.asList(23, 25, 33, 36, 39, 41)),
        Lotto.issueByManual(Arrays.asList(1, 3, 5, 14, 22, 45)),
        Lotto.issueByManual(Arrays.asList(5, 9, 38, 41, 43, 44)),
        Lotto.issueByManual(Arrays.asList(2, 8, 9, 18, 19, 21)),
        Lotto.issueByManual(Arrays.asList(13, 14, 18, 21, 23, 35)),
        Lotto.issueByManual(Arrays.asList(17, 21, 29, 37, 42, 45)),
        Lotto.issueByManual(Arrays.asList(3, 8, 27, 30, 35, 44))
    );

    //when
    WinningResult winningResult = new WinningResult(lottos, winningInfo);

    //then
    double expected = (double) LottoPrize.FIFTH.prizeMoney() / (14 * Lotto.PRICE.value());
    assertThat(winningResult.rateOfReturn()).isEqualTo(expected);
  }
}
