package study.lottogame.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import study.lottogame.domain.Lottery;
import study.lottogame.domain.LottoNumber;

public class LottoNumbersGenerator {

  private static final List<Integer> numbers;

  static {
    numbers = new ArrayList<>();
    for (int i = LottoNumber.MIN_LOTTO_NUMBER; i <= LottoNumber.MAX_LOTTO_NUMBER; i++) {
      numbers.add(i);
    }
  }

  private LottoNumbersGenerator() {
  }

  public static List<LottoNumber> generate() {
    return getAutoLottoNumbers();
  }

  private static List<LottoNumber> getAutoLottoNumbers() {
    Collections.shuffle(numbers);
    List<LottoNumber> lottoNumbers = new ArrayList<>();
    for (int i = 0; i < Lottery.LOTTO_NUMBER_COUNT; i++) {
      lottoNumbers.add(LottoNumber.valueOf(numbers.get(i)));
    }
    return lottoNumbers;
  }

  public static List<LottoNumber> generate(String[] numbers) {
    return getManualLottoNumbers(numbers);
  }

  private static List<LottoNumber> getManualLottoNumbers(String[] numbers) {
    List<LottoNumber> lottoNumbers = new ArrayList<>();
    for (String number : numbers) {
      StringUtils.checkNullOrBlank(number);
      lottoNumbers.add(LottoNumber.valueOf(Integer.parseInt(number.trim())));
    }
    return lottoNumbers;
  }
}
