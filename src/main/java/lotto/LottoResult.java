package lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Reward;
import lotto.domain.WinningNumbers;

import java.util.*;

public class LottoResult {

   private static final Map<Reward, Integer> rewardMap = new EnumMap<>(Reward.class);

   private Lottos lottos;
   private WinningNumbers winningNumbers;


   public LottoResult(Lottos lottos, WinningNumbers winningNumbers) {
      this.lottos = lottos;
      this.winningNumbers = winningNumbers;
   }

   public double lottoYieldCalculate(Money money){
      long sum = rewardMap.keySet()
              .stream()
              .mapToLong(Reward::getRewordMoney)
              .sum();
      return (sum  / (double)money.getMoney());
   }

   public Map<Reward, Integer> matchResult(){
      for (Reward reward : lottos.lottosMatch(winningNumbers)){
         rewardMap.put(reward, rewardMap.getOrDefault(reward, 0) + 1);
      }
      return rewardMap;
   }
}



