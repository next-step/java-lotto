package lotto.generator;


import lotto.type.LottoNumList;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumGenerator {

  private final int lottoSize;
  private final int maxLottoCandidateNum;

  public LottoNumGenerator(int lottoSize, int maxLottoCandidateNum) {
    this.lottoSize = lottoSize;
    this.maxLottoCandidateNum = maxLottoCandidateNum;
  }

  public LottoNumList generate(ShuffleStrategy shuffleStrategy) {
    List<Integer> res =  IntStream
        .rangeClosed(1, maxLottoCandidateNum)
        .boxed()
        .collect(Collectors.toList());

    res = shuffleStrategy.shuffle(res);
    res = res.subList(0, lottoSize);
    Collections.sort(res);

    return LottoNumList.valueOf(res);
  }
}
