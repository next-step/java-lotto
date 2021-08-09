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

  public LottoResult getInputMatchTotalInfo(final WinLottoInfo winLottoInfo) {
    lottoResult = new LottoResult();

    for (Lotto lotto : lottos) {
      getLottosByRank(winLottoInfo, lotto).add(lotto);
    }

    lottoResult.getCategoriesRank().remove(Rank.MISS);
    return lottoResult;
  }

  private List<Lotto> getLottosByRank(final WinLottoInfo winLottoInfo,
      final Lotto lotto) {
    return lottoResult.getMatchLottos(getMatchCountForRank(winLottoInfo, lotto));
  }

  private Rank getMatchCountForRank(WinLottoInfo winLottoInfo, Lotto lotto) {
    return Rank.matchRank(getCountByRank(winLottoInfo, lotto, INT_ZERO),
        isMatchBonus(winLottoInfo, lotto));
  }

  private int getCountByRank(final WinLottoInfo winLottoInfo, final Lotto lotto, int count) {
    for (LottoNumber lottoNumber : winLottoInfo.getLottoNumbers()) {
      count = checkContainValues(lotto, count, lottoNumber);
    }
    return count;
  }

  private int checkContainValues(final Lotto lotto, int count, final LottoNumber lottoNumber) {
    //if (lotto.getLotto().contains(lottoNumber)) {
    if (lotto.match(lottoNumber)) {
      count++;
    }
    return count;
  }

  private boolean isMatchBonus(final WinLottoInfo winLottoInfo, final Lotto lotto) {
    return lotto.getLotto().contains(winLottoInfo.getBonusLottoNumber());
  }
}
