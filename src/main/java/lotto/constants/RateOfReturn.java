package lotto.constants;

import lotto.exception.LottoGameException;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

import static lotto.constants.Message.RATE_OF_RETURN_IS_NOT_NEGATIVE_NUMBER;

public enum RateOfReturn {

  GAIN("이득임", rateOfReturn -> rateOfReturn > 1D),
  SAME("이득도 손해도 아님", rateOfReturn -> rateOfReturn == 1D),
  LOSS("기준이 1이기 때문에 결과적으로 손해라는 의미임", rateOfReturn -> rateOfReturn >= 0D && rateOfReturn < 1D);

  private final String message;

  private final Predicate<Double> getRateOfReturn;

  RateOfReturn(String message, Predicate<Double> getRateOfReturn) {
    this.message = message;
    this.getRateOfReturn = getRateOfReturn;
  }

  public static RateOfReturn of(double rateOfReturn) {
    return make(rateOfReturn)
        .orElseThrow(() -> new LottoGameException(RATE_OF_RETURN_IS_NOT_NEGATIVE_NUMBER));
  }

  private static Optional<RateOfReturn> make(double rateOfReturn) {
    return Arrays.stream(RateOfReturn.values())
        .filter(value -> value.getRateOfReturn.test(rateOfReturn))
        .findFirst();
  }

  public String getMessage() {
    return message;
  }
}
