package domain.prizeBoard;

import java.util.HashMap;
import java.util.Map;

public class PrizeBoardMapping {

  private static Map<Integer, Integer> prizeBoardMap = new HashMap<>();

  static {
    prizeBoardMap.put(3, PrizeBoard.MATCH3.matchPrize());
    prizeBoardMap.put(4, PrizeBoard.MATCH4.matchPrize());
    prizeBoardMap.put(5, PrizeBoard.MATCH5.matchPrize());
    prizeBoardMap.put(6, PrizeBoard.MATCH6.matchPrize());
  }

  public static int getPrize(int matchnum) {
    return prizeBoardMap.get(matchnum);
  }

}
