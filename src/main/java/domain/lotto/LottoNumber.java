package domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {

  private static final int MINIMUM_NUMBER = 1;
  private static final int MAXIMUM_NUMBER = 45;

  public static final List<Integer> lottoNumbers = new ArrayList<>();

  static {
    for (int i = MINIMUM_NUMBER; i <= MAXIMUM_NUMBER; i++) {
      lottoNumbers.add(i);
    }
  }
}