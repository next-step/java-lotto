package lotto.domain;

import lotto.domain.model.LottoNumber;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.PrizeGrade.FIRST_CLASS;
import static lotto.domain.PrizeGrade.SECOND_CLASS;
import static org.assertj.core.api.Assertions.assertThat;

class LottoGameConditionTest {

  @ParameterizedTest
  @MethodSource("provideTestingGetPrizeResult")
  void prizeResult_테스(LottoGameCondition winningCondition, List<LottoGame> lottoGames, List<PrizeGrade> expect) {
    assertThat(winningCondition.prizeResult(lottoGames)).isEqualTo(expect);
  }

  static Stream<Arguments> provideTestingGetPrizeResult() {

    List<LottoNumber> lastWeekWinGame = Arrays.asList(
        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
        new LottoNumber(4), new LottoNumber(5), new LottoNumber(45));

    LottoNumber bonusNumber = new LottoNumber(6);

    LottoGameCondition lottoGameCondition = new LottoGameCondition(new LottoGame(lastWeekWinGame), bonusNumber);

    List<LottoNumber> lottoNumbers = Arrays.asList(
        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
    List<LottoNumber> lottoNumbers2 = Arrays.asList(
        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

    return Stream.of(
        Arguments.of(
            lottoGameCondition,
            Arrays.asList(new LottoGame(lottoNumbers)),
            Arrays.asList(SECOND_CLASS)
        ),
        Arguments.of(
            lottoGameCondition,
            Arrays.asList(new LottoGame(lottoNumbers2)),
            Arrays.asList(FIRST_CLASS)
        )
    );
  }
}