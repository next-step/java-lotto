package lotto.model;

import java.util.List;

public class LottoValidationUtils {

  private final static int SIZE = 6;

  private LottoValidationUtils() {
  }

  public static void checkLottoNumberSize(List<Integer> numbers) {
    if (numbers.size() != SIZE) {
      throw new IllegalArgumentException("로또 숫자는 6개가 입력되어야 합니다. " + numbers);
    }
  }

  public static void checkLottoNumberRange(List<Integer> numberList) {
    if (!LottoNumberPool.INSTANCE.getNumbers().containsAll(numberList)) {
      throw new IllegalArgumentException("로또 숫자는 1~45 사이로 입력되어야 합니다.");
    }
  }
}
