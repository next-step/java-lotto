package lotto.domain.prize;

import java.util.HashMap;
import java.util.Map;

public class PrizeMapper {
  private Map<Long, LottoPrize> prizeMap;

  public PrizeMapper() {
    LottoPrize[] prizes = LottoPrize.values();
    Long[] countMatches = { 6L, 5L, 4L, 3L };
    prizeMap = new HashMap<>(prizes.length);

    for (int i = 0; i < prizes.length; i++) {
      prizeMap.put(countMatches[i], prizes[i]);
    }
  }

  public long findPrizeByCountMatches(long countMatches) {
    return prizeMap.get(countMatches).getPrize();
  }
}
