package lotto.domain;

import lotto.domain.strategy.NumberGenerateStrategy;
import lotto.domain.strategy.TestNumberGenerateStrategy;
import lotto.dto.AnalysisSheet;
import lotto.dto.OrderSheet;
import lotto.dto.TotalOrderedLottoGameDescription;
import lotto.dto.WinningNumbersAndBonusNumber;
import lotto.util.TestUtil;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

  private LottoMachine givenLottoMachine;

  @BeforeEach
  void setUp() {
    List<List<Integer>> manualNumbers = Lists.list(Lists.newArrayList(1, 2, 3, 4, 5, 6));
    OrderSheet givenOrderSheet = OrderSheet.of(2000L, manualNumbers);
    NumberGenerateStrategy givenNumberGenerateStrategy = new TestNumberGenerateStrategy(TestUtil.getOneToSixLottoNumbers());
    GameGenerator givenGameGenerator = new GameGenerator(givenOrderSheet, givenNumberGenerateStrategy);
    givenLottoMachine = new LottoMachine(givenGameGenerator);
  }

  @DisplayName("생성된 로또 게임들의 번호들 목록을 반환한다.")
  @Test
  void peekOrderedGamesTest() {
    //given
    List<LottoGame> expectGaems = Lists.newArrayList(TestUtil.createManualLottoGameFromLottoNumbers("1,2,3,4,5,6"), TestUtil.createAutoLottoGameFromLottoNumbers("1,2,3,4,5,6"));
    assertThat(givenLottoMachine.peekOrderedGames())
        .isEqualTo(new TotalOrderedLottoGameDescription(expectGaems));
  }

  @DisplayName("당첨 번호를 맞춰 본 후 당첨 내역 목록과 손익률을 반환한다.")
  @Test
  void confirmPrizeOrderedLottosTest() {
    //given
    List<Integer> givenWinningNumbers = Lists.newArrayList(1, 2, 3, 4, 5, 7);
    int givenBonusNumber = 6;
    WinningNumbersAndBonusNumber givenWinningNumbersAndBonusNumber = new WinningNumbersAndBonusNumber(givenWinningNumbers, givenBonusNumber);
    TotalRankings expectTotalRanking = new TotalRankings(Lists.newArrayList(LottoRanking.SECOND, LottoRanking.SECOND));

    //when & then
    assertThat(givenLottoMachine.confirmPrizeOrderedLottos(givenWinningNumbersAndBonusNumber))
        .isEqualTo(new AnalysisSheet(expectTotalRanking, 2000L));
  }

}
