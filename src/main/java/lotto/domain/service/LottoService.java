package lotto.domain.service;

import lotto.domain.dto.LottoResult;
import lotto.domain.entity.Budget;
import lotto.domain.entity.LottoTicket;
import lotto.domain.entity.LottoTickets;
import lotto.domain.entity.Prize;
import lotto.domain.entity.PrizeEntry;
import lotto.domain.entity.YieldRate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoService {

  private static final int LOTTO_FEE = 1000;
  private static final String CAN_NOT_PURCHASED = "로또를 구매할 수 없습니다.";

  private final LottoTicketCreator creator;

  public LottoService(LottoTicketCreator creator) {
    this.creator = creator;
  }

  public LottoTickets buyTheLottoTickets(Budget budget) {
    validBudget(budget);

    List<LottoTicket> lottoTickets = new ArrayList<>();
    while (!budget.isEmpty()) {
      lottoTickets.add(creator.pickLottoTicket());
      budget.minusBudget(LOTTO_FEE);
    }
    
    return new LottoTickets(lottoTickets);
  }

  private void validBudget(Budget budget) {
    if (budget.isEmpty()) {
      throw new IllegalArgumentException(CAN_NOT_PURCHASED);
    }
  }

  public LottoResult getLottoResult(LottoTicket winningTicket, LottoTickets lottoTickets) {
    PrizeEntry prizeEntry = new PrizeEntry(getPrizeResult(winningTicket, lottoTickets));
    YieldRate yieldRate = new YieldRate(calculateYieldRate(lottoTickets, prizeEntry));

    return new LottoResult(prizeEntry, yieldRate);
  }

  private Map<Prize, Integer> getPrizeResult(LottoTicket winningTicket, LottoTickets lottoTickets) {
    Map<Prize, Integer> prizeMap = new EnumMap<>(Prize.class);

    Arrays.stream(Prize.values())
          .forEach(prize -> {
            int numberOfMatched = lottoTickets.getCountOfMatch(winningTicket, prize.getMatchedCount());
            prizeMap.put(prize, numberOfMatched);
          });

    return prizeMap;
  }

  private double calculateYieldRate(LottoTickets lottoTickets, PrizeEntry prizeEntry) {
    int sumOfReward = prizeEntry.stream()
                                .mapToInt(entry -> entry.getKey().getReward() * entry.getValue())
                                .sum();

    return sumOfReward / ((double) LOTTO_FEE * lottoTickets.size());
  }

}
