package domain.lotto;

import domain.prizeBoard.PrizeBoardMapping;
import domain.strategy.GenerateLottoNum;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoMachine {

  private static final int MIN_INDEX = 3;
  private static final int MAX_INDEX = 6;

  private static final float LOTTOPRICE = 1000.0f;

  private Lottos lottos;

  public float revenueRatio(int amount, float totalPrize) {
    validationAmount(amount);
    return (totalPrize / (LOTTOPRICE * amount));
  }

  public float calculateTotalPrize(Map<Integer, Integer> prizeMap) {
    int totalPrize = 0;
    for (int i = MIN_INDEX; i <= MAX_INDEX; i++) {
      int prize = PrizeBoardMapping.getPrize(i) * prizeMap.get(i);
      totalPrize += prize;
    }
    return (float) totalPrize;
  }

  public Lottos makeLottos(int amount, GenerateLottoNum generateLottoNum) {
    return new Lottos(amount, generateLottoNum);
  }

  public Map<Integer, Integer> checkPrizes(List<Integer> winningNums, Lottos lottos) {
    Map<Integer, Integer> prizeMap = new HashMap<>();
    initPrizeMap(prizeMap);
    lottos.lottos.stream().map(lotto -> lotto.lotto.retainAll(winningNums))
        .collect(Collectors.toList());
    lottos.lottos.stream()
        .map(lotto -> prizeMap.put(lotto.lotto.size(), prizeMap.get(lotto.lotto.size()) + 1))
        .collect(Collectors.toList());
    return prizeMap;
  }

  private Map<Integer, Integer> initPrizeMap(Map<Integer, Integer> prizeMap) {
    for (int i = 0; i <= MAX_INDEX; i++) {
      prizeMap.put(i, 0);
    }
    return prizeMap;
  }

  private void validationAmount(int amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("0개를 구매할 수 없습니다");
    }
  }

}
