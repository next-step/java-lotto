package lotto.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LottoScoreBoard {

  private static final int INIT_VALUE = 0;
  private static final String FIFTH_WINNER_KEY = "FIFTH";
  private static final String FOURTH_WINNER_KEY = "FOURTH";
  private static final String THIRD_WINNER_KEY = "THIRD";
  private static final String SECOND_WINNER_KEY = "SECOND";
  private static final String FIRST_WINNER_KEY = "FIRST";

  private final Map<String, Integer> matchResultMap;
  private final Money money;

  public LottoScoreBoard(Map<String, Integer> matchResultMap, Money money) {
    this.matchResultMap = matchResultMap;
    this.money = money;
  }

  public Map<String, Integer> getMatchResultMap() {
    return matchResultMap;
  }

  public static LottoScoreBoard createLottoResult(List<LottoRank> lottoMatchResult, Money money) {

    Map<String, Integer> resultMap = new HashMap<>();

    for (LottoRank result : lottoMatchResult) {
      initLottoRankWithPrize(resultMap, result);
    }

    return new LottoScoreBoard(resultMap, money);
  }

  private static void initLottoRankWithPrize(Map<String, Integer> resultMap, LottoRank rankResult) {
    if(!LottoRank.isNone(rankResult)) {
      putLottoMatchResult(resultMap, rankResult);
    }
  }

  private static void putLottoMatchResult(Map<String, Integer> earningBoard, LottoRank key) {
    earningBoard.put(key.name(),
        earningBoard.getOrDefault(key.name(), 0) + 1);
  }

  public double getEarningRate() {
    Map<String, Integer> matchResultMap = getMatchResultMap();
    return money.calculateEarningRate(getTotalWinningMoney(matchResultMap));
  }

  private int getTotalWinningMoney(Map<String, Integer> map) {
    Iterator<Entry<String, Integer>> entries = map.entrySet().iterator();

    int total = INIT_VALUE;

    while (entries.hasNext()) {
      Map.Entry<String, Integer> entry = entries.next();
      total += getWinningMoney(entry);
    }

    return total;
  }

  private int getWinningMoney(Entry<String, Integer> entry) {
    LottoRank prize = LottoRank.findRank(entry.getKey());
    return prize.getWinnerMoney()
        .calculateWinningMoney(entry.getValue());
  }

  public String toResultString() {
    return "3개 일치 (5000원) - " + matchResultMap.getOrDefault(FIFTH_WINNER_KEY, INIT_VALUE) + "개\n"
           + "4개 일치 (50000원) - " + matchResultMap.getOrDefault(FOURTH_WINNER_KEY, INIT_VALUE) + "개\n"
           + "5개 일치 (1500000원) - " + matchResultMap.getOrDefault(THIRD_WINNER_KEY, INIT_VALUE) + "개\n"
           + "5개 일치, 보너스 볼 일치(30000000원) - " + matchResultMap.getOrDefault(SECOND_WINNER_KEY, INIT_VALUE) + "개\n"
           + "6개 일치 (2000000000원) - " + matchResultMap.getOrDefault(FIRST_WINNER_KEY, INIT_VALUE) + "개";
  }
}
