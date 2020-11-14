package lotto.domain.model;

import lotto.constants.PrizeGrade;
import lotto.domain.LottoGame;
import lotto.domain.LottoResults;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGamesTest {

  @ParameterizedTest
  @MethodSource("provideLottoResultMaterial")
  void 로또_당첨결과_확인_테스트(LottoGames lottoGames, LottoGame winGame, List<PrizeGrade> expect) {
    assertThat(lottoGames.confirmPrize(winGame)).isEqualTo(new LottoResults(expect));
  }

  static Stream<Arguments> provideLottoResultMaterial() {

    String[] oneToSeven = IntStream.range(1, 7).mapToObj(String::valueOf).collect(Collectors.toList()).toArray(new String[]{});
    String[] eightToFourteen = IntStream.range(8, 14).mapToObj(String::valueOf).collect(Collectors.toList()).toArray(new String[]{});
    String[] FifteenToTwenty = IntStream.range(15, 21).mapToObj(String::valueOf).collect(Collectors.toList()).toArray(new String[]{});

    PrizeGrade allMatch = PrizeGrade.of(6);
    PrizeGrade nonMatch1 = PrizeGrade.of(0);
    PrizeGrade nonMatch2 = PrizeGrade.of(0);

    return Stream.of(
        Arguments.of(new LottoGames(Arrays.asList(new LottoGame(oneToSeven), new LottoGame(eightToFourteen), new LottoGame(FifteenToTwenty))),
            new LottoGame(oneToSeven),
            Arrays.asList(allMatch, nonMatch1, nonMatch2)
        )
    );
  }


}