package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoGenerator implements LottoGenerator {

  private static final List<LottoNumber> NUMBERS = new ArrayList<>();

  static {
    for (int i = LottoNumber.MIN_LOTTO_NUMBER; i <= LottoNumber.MAX_LOTTO_NUMBER; i++) {
      NUMBERS.add(new LottoNumber(i));
    }
  }

  @Override
  public Lotto generate() {
    List<LottoNumber> numbersCopied = new ArrayList<>(NUMBERS);
    Collections.shuffle(numbersCopied);
    List<LottoNumber> sublist = numbersCopied.subList(0, Lotto.SIZE);
    Collections.sort(sublist);
    return new Lotto(sublist);
  }
}
