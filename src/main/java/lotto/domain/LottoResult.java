package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

   private static final Map<Reward, Integer> rewardMap = new HashMap<>();

   private Lottos lottos;
   private WinningNumbers winningNumbers;

   public LottoResult(Lottos lottos, WinningNumbers winningNumbers) {
      this.lottos = lottos;
      this.winningNumbers = winningNumbers;
   }

   public Map<Reward, Integer> matchResult(){
      for (Reward reward : lottosMatch()){
         rewardMap.put(reward, rewardMap.getOrDefault(reward, 0) + 1);
      }
      return rewardMap;
   }

   private List<Reward> lottosMatch(){
      return lottos.getLottos().stream()
              .map(lottoTicket -> Reward.rewardMatchCount(lottoMatchCount(lottoTicket)))
              .collect(Collectors.toList());
   }

   private int lottoMatchCount(LottoTicket lottoTicket){
      return  (int) lottoTicket.getTicket().stream()
              .filter(i -> winningNumbers.getWinningNumbers().contains(i))
              .count();
   }
}



