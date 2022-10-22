package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoMachine {
  private Lottos lottos;
  private final int MIN_INDEX=3;
  private final int MAX_INDEX=6;

  Map<Integer,Integer> prizeMap = new HashMap<>();

  public float revenueRatio(int amount, float totalPrize){
    validationAmount(amount);
    return (float) (totalPrize / (1000.0 * amount));
  }

  private void validationAmount(int amount) {
    if (amount <=0){
      throw new IllegalArgumentException("0개를 구매할 수 없습니다");
    }
  }

  public float calculateTotalPrize(List<Integer> winningNums,int amount){
    checkPrizes(winningNums,amount);
    int totalPrize = 0;
    for(int i=MIN_INDEX;i<=MAX_INDEX;i++){
      int prize = mapPrizeBoard(i) * prizeMap.get(i);
      totalPrize += prize;
    }
    return (float) totalPrize;
  }

  private Map<Integer,Integer> checkPrizes(List<Integer> winningNums, int amount){
    lottos = new Lottos(amount);
    initPrizeMap();
    lottos.lottos.stream()
        .map(lotto -> lotto.lotto.retainAll(winningNums))
        .collect(Collectors.toList());
    lottos.lottos.stream()
        .map(lotto -> prizeMap.put(lotto.lotto.size(),prizeMap.get(lotto.lotto.size())+1))
        .collect(Collectors.toList());
    return prizeMap;
  }

  private void initPrizeMap(){
    for (int i=0;i<=MAX_INDEX;i++){
      prizeMap.put(i,0);
    }
  }

  public Map<Integer, Integer> getPrizeMap() {
    return prizeMap;
  }

  private int mapPrizeBoard(int sameCount){
    if (sameCount==3){
      return 5000;
    }
    if(sameCount==4){
      return 50000;
    }
    if(sameCount==5){
      return 1500000;
    }
    if(sameCount==6){
      return 2000000000;
    }
    return 0;
  }

}
