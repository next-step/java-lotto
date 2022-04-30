package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoNumberComparsion {

  private final Lottos lottos;
  private final WinningLotto winningLotto;
  private final Map<LottoRank, Integer> matchResult;
  private final double profitRatio;

  public LottoNumberComparsion(Lottos lottos, WinningLotto winningLotto) {
    this.lottos = lottos;
    this.winningLotto = winningLotto;
    this.matchResult = matchLottoRankResult();
    this.profitRatio = calculateProfitRatio();
  }

  public Map<LottoRank, Integer> matchLottoRankResult() {
    return Arrays.stream(LottoRank.values())
        .collect(Collectors.toMap(Function.identity(), this::matchLottoRank));
  }

  private int matchLottoRank(LottoRank lottoRank) {
    return lottos.matchLottoRankResult(lottoRank, winningLotto);
  }

  private double calculateProfitRatio() {
    return lottos.calculateProfitRatio(winningLotto);
  }

  public Map<LottoRank, Integer> getMatchResult() {
    return matchResult;
  }

  public double getProfitRatio() {
    return profitRatio;
  }
}
