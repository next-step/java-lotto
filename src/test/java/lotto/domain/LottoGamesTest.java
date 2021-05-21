package lotto.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.TestUtil.getOneToSixLottoNumbers;
import static lotto.domain.TestUtil.toNumbers;
import static org.assertj.core.api.Assertions.assertThat;

class LottoGamesTest {

  @DisplayName("객체 생성 & 동등성 테스트")
  @Test
  void testConstruct() {
    //given
    List<LottoGame> given = Lists.newArrayList(new LottoGame(new LottoNumbers(getOneToSixLottoNumbers())));
    List<LottoGame> expectation = Lists.newArrayList(new LottoGame(new LottoNumbers(getOneToSixLottoNumbers())));
    //when & then
    assertThat(new LottoGames(given)).isEqualTo(new LottoGames(expectation));
  }

  @DisplayName("당첨 번호를 맞춰봤을 때 기대하는 총 당첨 결과를 반환한다.")
  @ParameterizedTest
  @MethodSource("provideMatchRankingsSource")
  void matchRankingsTest(LottoGames givenGames, TotalRankings expectation) {
    // given winning game
    LottoGame winningGame = new LottoGame(new LottoNumbers(getOneToSixLottoNumbers()));

    assertThat(givenGames.matchRankings(winningGame)).isEqualTo(expectation);

  }

  private static Stream<Arguments> provideMatchRankingsSource() {


    return Stream.of(
        Arguments.of(new LottoGames(Lists.newArrayList(createLottoGameFromLottoNumbers("1,2,3,4,5,6"))),
                    new TotalRankings(Lists.newArrayList(LottoRanking.FIRST))
        ),
        Arguments.of(new LottoGames(Lists.newArrayList(createLottoGameFromLottoNumbers("1,2,3,4,5,6"), createLottoGameFromLottoNumbers("1,2,3,10,20,30"))),
                    new TotalRankings(Lists.newArrayList(LottoRanking.FIRST, LottoRanking.FOURTH))
        ),
        Arguments.of(new LottoGames(Lists.newArrayList(createLottoGameFromLottoNumbers("10,20,30,40,15,25"), createLottoGameFromLottoNumbers("1,2,3,10,20,30"))),
            new TotalRankings(Lists.newArrayList(LottoRanking.NONE, LottoRanking.FOURTH))
        )
    );

  }

  private static LottoGame createLottoGameFromLottoNumbers(String numbers) {
    return new LottoGame(new LottoNumbers(toNumbers(numbers)));
  }



}
