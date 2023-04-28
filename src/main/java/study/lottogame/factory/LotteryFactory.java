package study.lottogame.factory;

import study.lottogame.domain.Lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LotteryFactory {

  private final static int LOTTO_MAX_NUMBER = 45;
  private static List<Integer> NUMBERS;

  static {
    NUMBERS = new ArrayList<>();
    for (int i = 1; i <= LOTTO_MAX_NUMBER; i++) {
      NUMBERS.add(i);
    }
  }

  private LotteryFactory() {
  }

  public static Lottery create() {
    return new Lottery(makeLottoNumbers());
  }

  private static List<Integer> makeLottoNumbers() {
    Collections.shuffle(NUMBERS);
    List<Integer> lottoNumbers = new ArrayList<>();
    for (int i = 0; i < 6; i++) {
      lottoNumbers.add(NUMBERS.get(i));
    }
    Collections.sort(lottoNumbers);

    return lottoNumbers;
  }


}
