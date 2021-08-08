package lotto.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.service.Rank;

public class LottoResult {

  private final Map<Rank, List<Lotto>> categoriesRank = new LinkedHashMap<>();

  public LottoResult() {
    categoriesRank.put(Rank.FIFTH, new ArrayList<>());
    categoriesRank.put(Rank.FOURTH, new ArrayList<>());
    categoriesRank.put(Rank.THIRD, new ArrayList<>());
    categoriesRank.put(Rank.FIRST, new ArrayList<>());
    categoriesRank.put(Rank.MISS, new ArrayList<>());
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

}