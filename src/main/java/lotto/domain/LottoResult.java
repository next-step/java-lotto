package lotto.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.service.Rank;

public class LottoResult {

  private final Map<Rank, List<Lotto>> categoriesRank = new LinkedHashMap<>();

  private WinLottoInfo winLottoInfo;

  public LottoResult(final WinLottoInfo winLottoInfo) {
    categoriesRank.put(Rank.FIFTH, new ArrayList<>());
    categoriesRank.put(Rank.FOURTH, new ArrayList<>());
    categoriesRank.put(Rank.THIRD, new ArrayList<>());
    categoriesRank.put(Rank.SECOND, new ArrayList<>());
    categoriesRank.put(Rank.FIRST, new ArrayList<>());
    categoriesRank.put(Rank.MISS, new ArrayList<>());

    this.winLottoInfo = winLottoInfo;
  }

  public Map<Rank, List<Lotto>> getCategoriesRank() {
    return categoriesRank;
  }

  public int getRankCount(Rank rank){
    return categoriesRank.get(rank).size();
  }

  public List<Lotto> getMatchLottos(final Rank matchCountForRank) {
    return categoriesRank.get(matchCountForRank);
  }

  public LottoResult matchLottoInfo(Lotteries lotteries) {

    for (Lotto lotto : lotteries.getLottos()) {
      getLottosByRank(lotto).add(lotto);
    }

    getCategoriesRank().remove(Rank.MISS);
    return this;
  }

  private List<Lotto> getLottosByRank(final Lotto lotto) {
    return getMatchLottos(winLottoInfo.getMatchCountForRank(lotto));
  }
}