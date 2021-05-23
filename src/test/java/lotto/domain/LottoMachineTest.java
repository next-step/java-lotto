package lotto.domain;

import lotto.dto.AnalysisSheet;
import lotto.dto.TotalOrderedLottoGameNumbers;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.util.TestUtil.createLottoGameFromLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

  private List<LottoGame> givenGames;
  private long givenPurchasedAmount = 2000;

  @BeforeEach
  void setUp() {
    givenGames = Lists.newArrayList(createLottoGameFromLottoNumbers("1,2,3,4,5,6"), createLottoGameFromLottoNumbers("1,2,3,10,20,30"));
  }

  @DisplayName("객체 생성 & 동등성 테스트")
  @Test
  void constructionAndEqualityTest() {
    assertThat(LottoMachine.staticFactoryMethodForTestCode(givenPurchasedAmount, givenGames))
        .isEqualTo(LottoMachine.staticFactoryMethodForTestCode(givenPurchasedAmount, givenGames));
  }

  @DisplayName("생성된 로또 게임들의 출력을 위한 DTO 객체를 반환 한다.")
  @Test
  void peekOrderedGamesTest() {
    assertThat(LottoMachine.staticFactoryMethodForTestCode(givenPurchasedAmount, givenGames).peekOrderedGames())
        .isEqualTo(new TotalOrderedLottoGameNumbers(givenGames));
  }

  @DisplayName("당첨 번호를 맞춰 본 후 당첨 내역과 손익률 출력을 위한 DTO 객체를 반환한다.")
  @Test
  void confirmPrizeOrderedLottosTest() {
    //given
    List<Integer> givenWinningNumbers = IntStream.range(1, 7)
        .boxed()
        .collect(Collectors.toList());

    TotalRankings expectTotalRanking = new TotalRankings(Lists.newArrayList(LottoRanking.FIRST, LottoRanking.FOURTH));

    //when & then
    assertThat(LottoMachine.staticFactoryMethodForTestCode(givenPurchasedAmount, givenGames).confirmPrizeOrderedLottos(givenWinningNumbers))
        .isEqualTo(new AnalysisSheet(expectTotalRanking, givenPurchasedAmount));
  }

}
