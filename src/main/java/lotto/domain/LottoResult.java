package lotto.domain;

import static java.util.Collections.unmodifiableList;
import static java.util.Collections.unmodifiableMap;
import static lotto.service.Operation.MULTIPLE;
import static lotto.service.Operation.chooseOperation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.dto.LotteriesDto;
import lotto.service.Rank;

public class LottoResult {

  private static final int COUNT = 1;

  private final Map<Rank, Integer> categoriesRanks;

  public LottoResult(final Map<Rank, Integer> result) {
    categoriesRanks = unmodifiableMap(result);
  }

  public static LottoResult getResult(final WinLottoInfo winLottoInfo, final LotteriesDto lotteries) {
    return new LottoResult(Collections.unmodifiableMap(getCountByRank(winLottoInfo, lotteries)));
  }

  public static Map<Rank, Integer> createRankByMap() {
    return creatRankInfo().stream()
        .collect(Collectors.toMap(rank -> rank, number -> 0, (a, b) -> b, LinkedHashMap::new));
  }

  private static Map<Rank, Integer> getCountByRank(final WinLottoInfo winLottoInfo,
      final LotteriesDto lotteries) {

    return matchLottosForRank(lotteries, winLottoInfo);
  }

  private static List<Rank> creatRankInfo() {
    List<Rank> ranks = new ArrayList<>();
    Collections.addAll(ranks, Rank.values());
    ranks.sort(Comparator.comparing(Rank::getWinningMoney));
    return unmodifiableList(ranks);
  }

  public int getRankCount(Rank rank) {
    return categoriesRanks.get(rank);
  }

  public double allRankResultSum() {
    return this.categoriesRanks.keySet()
        .stream()
        .mapToDouble(rank -> getCalculation(getRankCount(rank), rank.getWinningMoney())).sum();
  }

  private int getCalculation(final int matchCount, final int winningMoney) {
    return chooseOperation(MULTIPLE).calculation(matchCount, winningMoney);
  }

  private static String createResultMessageByRank(final Rank rank) {
    String messageForm = " (";

    if (rank.equals(Rank.SECOND)) {
      messageForm = ", 보너스 볼 일치 (";
    }
    return messageForm;
  }

  private static Map<Rank, Integer> matchLottosForRank(final LotteriesDto lotteries, final WinLottoInfo winLottoInfo) {

    Map<Rank, Integer> result = LottoResult.createRankByMap();

    lotteries.values().forEach(
        lotto -> result.computeIfPresent(winLottoInfo.getMatchCountForRank(lotto),
            (rank, integer) -> integer + COUNT));
    return result;
  }

  @Override
  public String toString() {
    return this.categoriesRanks
        .keySet()
        .stream()
        .filter(rank -> !rank.equals(Rank.MISS))
        .map(rank -> rank.getCountOfMatch() + "개 일치" + createResultMessageByRank(rank)
            + rank.getWinningMoney() + "원) - " + categoriesRanks.get(rank) + "개" + "\n")
        .collect(Collectors.joining());
  }

}