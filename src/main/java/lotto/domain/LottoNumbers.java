package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

  public static final int LOTTO_NUMBER_COUNT_INBOUND = 0;
  public static final int LOTTO_NUMBER_COUNT_OUTBOUND = 6;
  public static final int LOTTO_NUMBER_INBOUND = 1;
  public static final int LOTTO_NUMBER_OUTBOUND = 45;

  private static final List<LottoNumber> numbers = new ArrayList<>();

  static {
    for (int number = LOTTO_NUMBER_INBOUND; number <= LOTTO_NUMBER_OUTBOUND; number++) {
      numbers.add(new LottoNumber(number));
    }
  }

  public static LottoNumber pick(String number) {

    int value;
    try  {
      value = Integer.parseInt(number);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("숫자만 입력할 수 있습니다. 입력된 값 : " + number);
    }

    if (value < LottoNumbers.LOTTO_NUMBER_INBOUND || value > LottoNumbers.LOTTO_NUMBER_OUTBOUND) {
      throw new IllegalArgumentException(String.format("숫자는 %d ~ %d 사이의 값만 들어올 수 있습니다.", LottoNumbers.LOTTO_NUMBER_INBOUND, LottoNumbers.LOTTO_NUMBER_OUTBOUND));
    }

    return numbers.get(value - 1);
  }

  public static List<LottoNumber> collectBySize(int number) {
    List<LottoNumber> dump = new ArrayList<>(numbers);
    Collections.shuffle(dump);

    return dump.subList(LOTTO_NUMBER_COUNT_INBOUND, number);
  }
}
