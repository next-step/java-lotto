package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
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

  public Map<Integer, List<Lotto>> getInputMatchTotalInfo(
      final Map<Integer, List<Lotto>> categoriesRank, Lotto winLotto) {
    for (Lotto lotto : lottos) {
      categoriesRank.get(matchLottoRating(winLotto, lotto)).add(lotto);
    }

    categoriesRank.remove(INT_ZERO);
    return categoriesRank;
  }

  private int matchLottoRating(Lotto winLotto, Lotto lotty) {
    int matchLotteries = getMatchLotteries(lotty, winLotto);

    if (isLessThanLimit(matchLotteries)) {
      return INT_ZERO;
    }
    return matchLotteries;
  }

  private boolean isLessThanLimit(final int matchLotteries) {
    return matchLotteries < LIMIT_MATCH_NUMBER;
  }

  public int getMatchLotteries(Lotto lotty, Lotto winLotto) {
    int count = INT_ZERO;
    for (LottoNumber lottoNumber : lotty.getLotto()) {
      count = checkContainValues(winLotto, count, lottoNumber);
    }
    return count;
  }

  private int checkContainValues(final Lotto winLotto, int count, final LottoNumber lottoNumber) {
    if (winLotto.getLotto().contains(lottoNumber)) {
      count++;
    }
    return count;
  }

}
