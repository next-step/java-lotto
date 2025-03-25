package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoGenerator implements LottoGenerator {

    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final List<LottoNumber> numbers = new ArrayList<>();

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            numbers.add(new LottoNumber(i));
        }
    }

    @Override
    public Lotto generate() {
      List<LottoNumber> numbersCopied = new ArrayList<>(numbers);
      Collections.shuffle(numbersCopied);
      List<LottoNumber> sublist = numbersCopied.subList(0, Lotto.SIZE);
      Collections.sort(sublist);
      return new Lotto(sublist);
    }
}
