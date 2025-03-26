package lotto.generator;


import lotto.type.LottoNumList;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumGenerator {

  private final int lottoNumSize;
  private final int maxLottoCandidateNum;

  public LottoNumGenerator(int lottoNumSize, int maxLottoCandidateNum) {
    this.lottoNumSize = lottoNumSize;
    this.maxLottoCandidateNum = maxLottoCandidateNum;
  }

  public LottoNumList generate(ShuffleStrategy shuffleStrategy) {
    List<Integer> res =  IntStream
        .rangeClosed(1, maxLottoCandidateNum)
        .boxed()
        .collect(Collectors.toList());

    res = shuffleStrategy.shuffle(res);
    res = res.subList(0, lottoNumSize);
    Collections.sort(res);

    return LottoNumList.valueOf(res);
  }
}
