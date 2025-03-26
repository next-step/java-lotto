package lotto.generator;


import lotto.LottoSystemConstants;
import lotto.type.LottoNumList;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumGenerator {

  public LottoNumList generate(ShuffleStrategy shuffleStrategy) {
    List<Integer> res = IntStream
        .rangeClosed(LottoSystemConstants.LOTTO_MIN_NUM, LottoSystemConstants.LOTTO_MAX_NUM)
        .boxed()
        .collect(Collectors.toList());

    res = shuffleStrategy.shuffle(res);
    res = res.subList(0, LottoSystemConstants.LOTTO_SIZE);
    Collections.sort(res);

    return LottoNumList.valueOf(res);
  }
}
