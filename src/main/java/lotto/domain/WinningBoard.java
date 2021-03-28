package lotto.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WinningBoard {

  private static final int INIT_VALUE = 0;
  private static final String FOURTH_WINNER_KEY = "FOURTH";
  private static final String THIRD_WINNER_KEY = "THIRD";
  private static final String SECOND_WINNER_KEY = "SECOND";
  private static final String FIRST_WINNER_KEY = "FIRST";

  private final Map<String, Integer> matchResultMap;
  private final Money money;

  public WinningBoard(Map<String, Integer> matchResultMap, Money money) {
    this.matchResultMap = matchResultMap;
    this.money = money;
  }

  public Map<String, Integer> getMatchResultMap() {
    return matchResultMap;
  }

  public static WinningBoard createLottoResult(List<Integer> lottoMatchResult, Money money) {

    Map<String, Integer> resultMap = new HashMap<>();

    for (int result : lottoMatchResult) {
      initPrizeResultFromMatchLotto(resultMap, result);
    }

    return new WinningBoard(resultMap, money);
  }

  private static void initPrizeResultFromMatchLotto(Map<String, Integer> resultMap, int result) {
    MatchLotto matchLotto = MatchLotto.valueOf(result);
    if(!MatchLotto.isNone(matchLotto)) {
      putLottoMatchResult(resultMap, matchLotto);
    }
  }

  private static void putLottoMatchResult(Map<String, Integer> earningBoard, MatchLotto key) {
    earningBoard.put(key.name(), earningBoard.getOrDefault(key.name(), 0) + 1);
  }

  public String calculateEarningRate() {
    Map<String, Integer> matchResultMap = getMatchResultMap();

    int total = getTotalEarning(matchResultMap);
    int boughtMoney = this.money.toInt();

    double earning = (total / (double)boughtMoney);
    return String.valueOf(String.format("%.1f", earning));
  }

  private int getTotalEarning(Map<String, Integer> map) {
    Iterator<Entry<String, Integer>> entries = map.entrySet().iterator();

    int total = INIT_VALUE;

    while (entries.hasNext()) {
      Map.Entry<String, Integer> entry = entries.next();
      total += getEarning(entry);
    }

    return total;
  }

  private int getEarning(Entry<String, Integer> entry) {
    MatchLotto prize = MatchLotto.findPrize(entry.getKey());
    return entry.getValue() * prize.getWinnerMoney();
  }

  public String toResultString() {
    return "3개 일치 (5000원) - " + matchResultMap.getOrDefault(FOURTH_WINNER_KEY, INIT_VALUE) + "개"
        + "\n4개 일치 (50000원) - " + matchResultMap.getOrDefault(THIRD_WINNER_KEY, INIT_VALUE) + "개"
        + "\n5개 일치 (1500000원) - " + matchResultMap
        .getOrDefault(SECOND_WINNER_KEY, INIT_VALUE) + "개"
        + "\n6개 일치 (2000000000원) - " + matchResultMap
        .getOrDefault(FIRST_WINNER_KEY, INIT_VALUE) + "개";
  }
}
