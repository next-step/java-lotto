package step02.code.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ResultCalculatorTest {
  @ParameterizedTest
  @MethodSource("profitTestCase")
  @DisplayName("수익율 계산")
  public void profit(int money, Map<GradeEnum, Integer> result, float profit) {
    // Outcome outcome = new Outcome(money, null);
    ResultCalculator resultCalculator = new ResultCalculator(money);
    resultCalculator = resultCalculator.calcTotal(result);
    

    assertThat(resultCalculator.profit()).isEqualTo(profit);
  }

  private static Stream<Arguments> profitTestCase() {
    return Stream.of(
      Arguments.of(
        5000,
        Map.of(GradeEnum.FIFTH, 2, GradeEnum.FOURTH, 1),
        12.0f
      )
    );
  }
}
