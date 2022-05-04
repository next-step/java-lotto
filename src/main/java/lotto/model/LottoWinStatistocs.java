package lotto.model;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoWinStatistocs {

  private final Lottos lottos;
  private final WinningLotto winningLotto;

  public LottoWinStatistocs(Lottos lottos, WinningLotto winningLotto) {
    this.lottos = lottos;
    this.winningLotto = winningLotto;
  }

  private int matchLottoRank(LottoRank lottoRank) {
    return lottos.matchLottoRankResult(lottoRank, winningLotto);
  }

  public Map<LottoRank, Integer> isMatchResult() {
    return Arrays.stream(LottoRank.values())
        .collect(Collectors.toMap(Function.identity(), this::matchLottoRank));
  }

  public double isProfitRatio() {
    return lottos.calculateProfitRatio(winningLotto);
  }
}
