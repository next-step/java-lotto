package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {

  private final List<Lotto> lottoList;

  public Lottos(List<Lotto> lottoList) {
    this.lottoList = lottoList;
  }

  public int getCount() {
    return lottoList.size();
  }

  public void printAllLottos() {
    lottoList.forEach(lotto -> System.out.println(lotto.getNumberRepresentation()));
  }

  public Map<LottoPrize, Integer> calculatePrize(Lotto winningLotto) {
    Map<LottoPrize, Integer> prizeMap = Arrays.stream(LottoPrize.values())
            .collect(Collectors.toMap(prize -> prize, prize -> 0));
    for (Lotto lotto : lottoList) {
      int count = lotto.countMatchingNumbers(winningLotto);
      if (count < LottoPrize.THREE_MATCHES.getMatchCount()) {
        continue;
      }
      prizeMap.put(LottoPrize.fromMatchCount(count), prizeMap.get(LottoPrize.fromMatchCount(count)) + 1);
    }
    return prizeMap;
  }
}
