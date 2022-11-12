package lotto.domain;
import java.util.*;

public class LottoResult {

   private static final Map<Reward, Integer> rewardMap = new HashMap<>();

   private Lottos lottos;
   private WinningNumbers winningNumbers;


   public LottoResult(Lottos lottos, WinningNumbers winningNumbers) {
      this.lottos = lottos;
      this.winningNumbers = winningNumbers;
   }

   public double lottoYieldCalculate(int money){
      long sum = rewardMap.keySet()
                 .stream()
                 .mapToLong(Reward::getRewordMoney)
                 .sum();
      return (sum  / (double)money);
   }

   public Map<Reward, Integer> matchResult(){
      for (Reward reward : lottos.lottosMatch(winningNumbers)){
         rewardMap.put(reward, rewardMap.getOrDefault(reward, 0) + 1);
      }
      return rewardMap;
   }
}



