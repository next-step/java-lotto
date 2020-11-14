package lotto.domain;

import lotto.constants.PrizeGrade;
import lotto.constants.RateOfReturn;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.constants.Message.RATE_OF_RETURN_FORMAT;
import static lotto.constants.PrizeGrade.THIRD_CLASS;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultsTest {

  @ParameterizedTest
  @MethodSource("provideRateOfReturnMaterial")
  void 수익률_확인_테스트(List<PrizeGrade> given, PurchaseAction purchaseAction, String expect) {
    LottoResults lottoResults = new LottoResults(given);
    assertThat(lottoResults.computeRateOfReturn(purchaseAction)).isEqualTo(expect);
  }

  @ParameterizedTest
  @MethodSource("providePrizeMoneySumMaterial")
  void 총상금_확인_테스트(List<PrizeGrade> given, long expect) {
    LottoResults lottoResults = new LottoResults(given);
    assertThat(lottoResults.prizeMoneySum()).isEqualTo(expect);
  }

  static Stream<Arguments> providePrizeMoneySumMaterial() {
    List<PrizeGrade> confirmResults = Arrays.stream(PrizeGrade.values())
        .filter(prizeGrade -> prizeGrade == THIRD_CLASS)
        .collect(Collectors.toList());

    return Stream.of(
        Arguments.of(confirmResults, 50000L)
    );
  }

  static Stream<Arguments> provideRateOfReturnMaterial() {
    List<PrizeGrade> confirmResults = Arrays.stream(PrizeGrade.values())
        .filter(prizeGrade -> prizeGrade == THIRD_CLASS)
        .collect(Collectors.toList());
    PurchaseAction purchaseAction = new PurchaseAction(14_000);
    double rateOfReturn = (double) THIRD_CLASS.getPrizeMoney() / (double) purchaseAction.getPurchasePrice();

    return Stream.of(
        Arguments.of(confirmResults, purchaseAction, String.format(RATE_OF_RETURN_FORMAT, rateOfReturn, RateOfReturn.of(rateOfReturn).getMessage()))
    );
  }
}