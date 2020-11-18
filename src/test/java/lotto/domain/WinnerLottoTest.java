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

class WinnerLottoTest {

  @ParameterizedTest
  @MethodSource("provideTestingGetPrizeResult")
  void prizeResult_테스(WinnerLotto winningCondition, List<Lotto> lottos, List<PrizeGrade> expect) {
    assertThat(winningCondition.prizeResult(lottos)).isEqualTo(expect);
  }

  static Stream<Arguments> provideTestingGetPrizeResult() {

    List<LottoNumber> lastWeekWinGame = Arrays.asList(
        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
        new LottoNumber(4), new LottoNumber(5), new LottoNumber(45));

    LottoNumber bonusNumber = new LottoNumber(6);

    WinnerLotto winnerLotto = new WinnerLotto(new Lotto(lastWeekWinGame), bonusNumber);

    List<LottoNumber> lottoNumbers = Arrays.asList(
        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
    List<LottoNumber> lottoNumbers2 = Arrays.asList(
        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
        new LottoNumber(4), new LottoNumber(5), new LottoNumber(45));

    return Stream.of(
        Arguments.of(
            winnerLotto,
            Arrays.asList(new Lotto(lottoNumbers)),
            Arrays.asList(SECOND_CLASS)
        ),
        Arguments.of(
            winnerLotto,
            Arrays.asList(new Lotto(lottoNumbers2)),
            Arrays.asList(FIRST_CLASS)
        )
    );
  }
}