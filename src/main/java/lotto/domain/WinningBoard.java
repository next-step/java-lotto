package lotto.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WinningBoard {

  private static final int INIT_VALUE = 0;
  private static final int FOURTH_CRITERIA = 3;
  private static final int THIRD_CRITERIA = 4;
  private static final int SECOND_CRITERIA = 5;
  private static final int FIRST_CRITERIA = 6;
  private static final int FOURTH_PRIZE_MONEY = 5000;
  private static final int THIRD_PRIZE_MONEY = 50000;
  private static final int SECOND_PRIZE_MONEY = 1500000;
  private static final int FIRST_PRIZE_MONEY = 2000000000;

  private static final String FOURTH_WINNER_KEY = "fourth";
  private static final String THIRD_WINNER_KEY = "third";
  private static final String SECOND_WINNER_KEY = "second";
  private static final String FIRST_WINNER_KEY = "first";

  private final Map<String, Integer> winningBoard;
  private final Money money;

  public WinningBoard(Map<String, Integer> winningBoard, Money money) {
    this.winningBoard = winningBoard;
    this.money = money;
  }

  public Map<String, Integer> getWinningBoard() {
    return winningBoard;
  }

  public static WinningBoard createLottoResult(List<Integer> lottoMatchResult, Money money) {

    Map<String, Integer> resultMap = new HashMap<>();

    for (int result : lottoMatchResult) {
      initPrizeResultFromMatchResult(resultMap, result);
    }

    return new WinningBoard(resultMap, money);
  }

  private static void initPrizeResultFromMatchResult(Map<String, Integer> resultMap, int result) {
    if (result == FOURTH_CRITERIA)
      putLottoMatchResult(resultMap, FOURTH_WINNER_KEY);

    if (result == THIRD_CRITERIA)
      putLottoMatchResult(resultMap, THIRD_WINNER_KEY);

    if (result == SECOND_CRITERIA)
      putLottoMatchResult(resultMap, SECOND_WINNER_KEY);

    if (result == FIRST_CRITERIA)
      putLottoMatchResult(resultMap, FIRST_WINNER_KEY);
  }

  private static void putLottoMatchResult(Map<String, Integer> earningBoard, String key) {
    earningBoard.put(key, earningBoard.getOrDefault(key, 0) + 1);
  }

  public String calculateEarningRate() {
    Map<String, Integer> winningBoard = getWinningBoard();

    int total = getTotal(winningBoard);
    int test = this.money.toInt();

    double earning = (total / (double)test);
    return String.valueOf(String.format("%.1f", earning));
  }

  private int getTotal(Map<String, Integer> map) {
    Iterator<Entry<String, Integer>> entries = map.entrySet().iterator();

    int total = INIT_VALUE;

    while (entries.hasNext()) {
      Map.Entry<String, Integer> entry = entries.next();
      total = getTotal(entry);
    }

    return total;
  }

  private int getTotal(Entry<String, Integer> entry) {
    int total = INIT_VALUE;

    if(isEquals(entry, FOURTH_WINNER_KEY))
      total += calculateTotalPrizeMoney(entry.getValue(), FOURTH_PRIZE_MONEY);

    if(isEquals(entry, THIRD_WINNER_KEY))
      total += calculateTotalPrizeMoney(entry.getValue(), THIRD_PRIZE_MONEY);

    if(isEquals(entry, SECOND_WINNER_KEY))
      total += calculateTotalPrizeMoney(entry.getValue(), SECOND_PRIZE_MONEY);

    if(isEquals(entry, FIRST_WINNER_KEY))
      total += calculateTotalPrizeMoney(entry.getValue(), FIRST_PRIZE_MONEY);

    return total;
  }

  private int calculateTotalPrizeMoney(int value, int prizeMoney) {
    return value * prizeMoney;
  }

  private boolean isEquals(Entry<String, Integer> entry, String fourthWinnerKey) {
    return entry.getKey().equals(fourthWinnerKey);
  }

  public String toResultString() {
    return "3개 일치 (5,000원) : " + winningBoard.getOrDefault(FOURTH_WINNER_KEY, INIT_VALUE) + "장"
        + "\n4개 일치 (50,000원) : " + winningBoard.getOrDefault(THIRD_WINNER_KEY, INIT_VALUE) + "장"
        + "\n5개 일치 (1,500,000원):  " + winningBoard.getOrDefault(SECOND_WINNER_KEY, INIT_VALUE) + "장"
        + "\n6개 일치 (2,000,000,000원) : " + winningBoard.getOrDefault(FIRST_WINNER_KEY, INIT_VALUE) + "장";
  }
}
