package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

  @Test
  @DisplayName("당첨 통계값 생성 및 결과값 확인 테스트")
  void createTest() {
    //given
    int[] winningNumbers = {1, 2, 3, 4, 5, 6};
    int bonusNumber = 7;
    WinningInfo winningInfo = new WinningInfo(winningNumbers, bonusNumber);

    List<Lotto> lottos = Arrays.asList(
        Lotto.issueByManual(Arrays.asList(1, 2, 3, 4, 5, 6)),        // 6개 일치, 보너스 x => FIRST
        Lotto.issueByManual(Arrays.asList(1, 2, 3, 4, 5, 7)),        // 5개 일치, 보너스 o => SECOND
        Lotto.issueByManual(Arrays.asList(1, 2, 3, 4, 6, 7)),        // 5개 일치, 보너스 o => SECOND
        Lotto.issueByManual(Arrays.asList(10, 2, 3, 4, 5, 6)),       // 5개 일치, 보너스 x => THIRD
        Lotto.issueByManual(Arrays.asList(1, 2, 3, 4, 7, 9)),        // 4개 일치, 보너스 o => FOURTH
        Lotto.issueByManual(Arrays.asList(1, 2, 3, 4, 8, 9)),        // 4개 일치, 보너스 x => FOURTH
        Lotto.issueByManual(Arrays.asList(1, 2, 3, 7, 44, 45)),      // 3개 일치, 보너스 o => FIFTH
        Lotto.issueByManual(Arrays.asList(1, 3, 6, 10, 11, 12)),     // 3개 일치, 보너스 x => FIFTH
        Lotto.issueByManual(Arrays.asList(1, 20, 30, 40, 41, 42))    // 1개 일치, 보너스 x => NOTHING
    );

    //when
    WinningStatistics statistics = new WinningStatistics(lottos, winningInfo);

    //then
    assertThat(statistics.cntByLottoPrize(LottoPrize.FIRST)).isEqualTo(1);
    assertThat(statistics.cntByLottoPrize(LottoPrize.SECOND)).isEqualTo(2);
    assertThat(statistics.cntByLottoPrize(LottoPrize.THIRD)).isEqualTo(1);
    assertThat(statistics.cntByLottoPrize(LottoPrize.FOURTH)).isEqualTo(2);
    assertThat(statistics.cntByLottoPrize(LottoPrize.FIFTH)).isEqualTo(2);
    assertThat(statistics.cntByLottoPrize(LottoPrize.NOTHING)).isEqualTo(1);
  }

  @Test
  @DisplayName("총 당첨금 구하기 테스트")
  void calcTotalPrizeMoneyTest() {
    //given
    int[] winningNumbers = {1, 2, 3, 4, 5, 6};
    int bonusNumber = 7;
    WinningInfo winningInfo = new WinningInfo(winningNumbers, bonusNumber);

    List<Lotto> lottos = Arrays.asList(
        Lotto.issueByManual(Arrays.asList(1, 2, 3, 4, 5, 6)),        // 6개 일치, 보너스 x => FIRST
        Lotto.issueByManual(Arrays.asList(1, 2, 3, 4, 5, 7)),        // 5개 일치, 보너스 o => SECOND
        Lotto.issueByManual(Arrays.asList(1, 3, 6, 10, 11, 12)),     // 3개 일치, 보너스 x => FIFTH
        Lotto.issueByManual(Arrays.asList(1, 2, 3, 42, 44, 45)),     // 3개 일치, 보너스 x => FIFTH
        Lotto.issueByManual(Arrays.asList(1, 20, 30, 40, 41, 42))    // 1개 일치, 보너스 x => NOTHING
    );

    //when
    WinningStatistics statistics = new WinningStatistics(lottos, winningInfo);

    //then
    assertThat(statistics.totalPrizeMoney())
        .isEqualTo(
            (LottoPrize.FIRST.prizeMoney())
                + (LottoPrize.SECOND.prizeMoney())
                + (LottoPrize.FIFTH.prizeMoney() * 2)
        );
  }
}
