package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import lotto.service.Rank;
import lotto.strategy.GenerateLottoNumber;

public class Lotteries {

  private static final int INT_ZERO = 0;

  private List<Lotto> lottos = new ArrayList<>();

  private LottoResult lottoResult;

  public Lotteries(int count) {
    lottos = createLotteries(count);
  }

  public Lotteries() {
  }

  public List<Lotto> getLottos() {
    return lottos;
  }

  private List<Lotto> createLotteries(int count) {
    return Collections.unmodifiableList(LongStream.range(INT_ZERO, count)
        .mapToObj(limit -> new Lotto(GenerateLottoNumber.createNumberPull()))
        .collect(Collectors.toList()));
  }

  public LottoResult getInputMatchTotalInfo(Lotto winLotto) {

    lottoResult = new LottoResult();

    for (Lotto lotto : lottos) {
      getLottosByRank(winLotto, lotto).add(lotto);
    }

    lottoResult.getCategoriesRank().remove(Rank.MISS);
    return lottoResult;
  }

  private List<Lotto> getLottosByRank(final Lotto winLotto,
      final Lotto lotto) {
    return lottoResult.getMatchLottos(getMatchCountForRank(winLotto, lotto));
  }

  private Rank getMatchCountForRank(Lotto lotty, Lotto winLotto) {
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
