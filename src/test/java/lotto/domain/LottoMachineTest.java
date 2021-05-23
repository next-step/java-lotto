package lotto.domain;

import lotto.domain.strategy.RandomNumberGenerateStrategy;
import lotto.domain.strategy.TestRandomNumberGenerateStrategy;
import lotto.dto.AnalysisSheet;
import lotto.dto.OrderSheet;
import lotto.dto.TotalOrderedLottoGameNumbers;
import lotto.util.TestUtil;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

  private LottoMachine givenLottoMachine;

  @BeforeEach
  void setUp() {
    OrderSheet givenOrderSheet = new OrderSheet(2000L);
    RandomNumberGenerateStrategy givenRandomNumberGenerateStrategy = new TestRandomNumberGenerateStrategy(TestUtil.getOneToSixLottoNumbers());
    GameGenerator givenGameGenerator = new GameGenerator(givenOrderSheet, givenRandomNumberGenerateStrategy);
    givenLottoMachine = new LottoMachine(givenGameGenerator);
  }

  @DisplayName("생성된 로또 게임들의 번호들 목록을 반환한다.")
  @Test
  void peekOrderedGamesTest() {
    //given
    List<LottoGame> expectGaems = Lists.newArrayList(TestUtil.createLottoGameFromLottoNumbers("1,2,3,4,5,6"), TestUtil.createLottoGameFromLottoNumbers("1,2,3,4,5,6"));
    assertThat(givenLottoMachine.peekOrderedGames())
        .isEqualTo(new TotalOrderedLottoGameNumbers(expectGaems));
  }

  @DisplayName("당첨 번호를 맞춰 본 후 당첨 내역 목록과 손익률을 반환한다.")
  @Test
  void confirmPrizeOrderedLottosTest() {
    //given
    List<Integer> givenWinningNumbers = IntStream.rangeClosed(1, 6)
        .boxed()
        .collect(Collectors.toList());

    TotalRankings expectTotalRanking = new TotalRankings(Lists.newArrayList(LottoRanking.FIRST, LottoRanking.FIRST));

    //when & then
    assertThat(givenLottoMachine.confirmPrizeOrderedLottos(givenWinningNumbers))
        .isEqualTo(new AnalysisSheet(expectTotalRanking, 2000L));
  }

}
