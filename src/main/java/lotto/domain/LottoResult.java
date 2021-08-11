package lotto.domain;

import static java.util.Collections.unmodifiableList;
import static java.util.Collections.unmodifiableMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.service.Rank;

public class LottoResult {

  private Map<Rank, Integer> categoriesRanks;

  public LottoResult(final Map<Rank, Integer> result) {
    categoriesRanks = unmodifiableMap(result);
  }

  public static LottoResult getResult(final WinLottoInfo winLottoInfo, final Lotteries lotteries) {

    Map<Rank, Integer> result = creatRankInfo().stream()
        .collect(Collectors.toMap(rank -> rank, number -> 0, (a, b) -> b, LinkedHashMap::new));

    getCountByRank(winLottoInfo, lotteries, result);

    return new LottoResult(result);
  }

  private static void getCountByRank(final WinLottoInfo winLottoInfo, final Lotteries lotteries,
      final Map<Rank, Integer> result) {
    for (Lotto lotto : lotteries.getLottos()){
      result.computeIfPresent(winLottoInfo.getMatchCountForRank(lotto),(rank, integer) -> integer +1);
    }
  }

  private static List<Rank> creatRankInfo() {
    List<Rank> ranks = new ArrayList<>();
    Collections.addAll(ranks, Rank.values());
    ranks.sort(Comparator.comparing(Rank::getWinningMoney));
    return unmodifiableList(ranks);
  }

  public Map<Rank, Integer> getCategoriesRanks() {
    return categoriesRanks;
  }

  public int getRankCount(Rank rank){
    return categoriesRanks.get(rank);
  }
}