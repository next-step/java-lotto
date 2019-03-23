package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {

  private final static int LOTTO_AMOUNT = 1_000;

  private final static int FROM_INDEX = 0;

  public static List<Lotto> buy(Money insertMoney) {

    int buyQuantity = insertMoney.buy(LOTTO_AMOUNT);

    List<Lotto> lottos = new ArrayList<>();
    for(int buyIndex = 0; buyIndex < buyQuantity; buyIndex++) {

      Set<LottoNumber> lottoNumbers = generateLottoNumbers();
      lottos.add(new Lotto(lottoNumbers));
    }
    return lottos;
  }

  private static Set<LottoNumber> generateLottoNumbers() {

    List<LottoNumber> lottoNumbers = IntStream.range(LottoNumber.MINIMUM, LottoNumber.MAXIMUM)
        .mapToObj(LottoNumber::new)
        .collect(Collectors.toList());
    Collections.shuffle(lottoNumbers);

    return new HashSet<>(lottoNumbers.subList(FROM_INDEX, FROM_INDEX + Lotto.NUMBERS_SIZE));
  }
}
