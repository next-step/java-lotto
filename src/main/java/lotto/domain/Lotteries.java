package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.service.Rank;
import lotto.strategy.GenerateLottoNumber;

public class Lotteries {

  private static final int INT_ZERO = 0;

  private static final int LIMIT_MATCH_NUMBER = 3;

  private final List<Lotto> lottos = new ArrayList<>();

  public Lotteries(int count) {
    createLotteries(count);
  }

  public Lotteries() {
  }

  public List<Lotto> getLottos() {
    return lottos;
  }

  private void createLotteries(int count) {
    Stream.generate(() -> new Lotto(GenerateLottoNumber.createNumberPull()))
        .limit(count)
        .forEach(lottos::add);
  }

  public Map<Rank, List<Lotto>> getInputMatchTotalInfo(
      final Map<Rank, List<Lotto>> categoriesRank, Lotto winLotto) {

    for (Lotto lotto : lottos) {
      categoriesRank.get(getMatchLotteries(winLotto, lotto)).add(lotto);
    }

    categoriesRank.remove(Rank.MISS);
    return categoriesRank;
  }

  public Rank getMatchLotteries(Lotto lotty, Lotto winLotto) {
    int count = INT_ZERO;
    for (LottoNumber lottoNumber : lotty.getLotto()) {
      count = checkContainValues(winLotto, count, lottoNumber);
    }
    return Rank.matchRank(count);
  }

  private int checkContainValues(final Lotto winLotto, int count, final LottoNumber lottoNumber) {
    if (winLotto.getLotto().contains(lottoNumber)) {
      count++;
    }
    return count;
  }

}
