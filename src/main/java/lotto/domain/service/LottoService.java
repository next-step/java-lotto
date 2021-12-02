package lotto.domain.service;

import lotto.domain.dto.LottoResult;
import lotto.domain.entity.Budget;
import lotto.domain.entity.LottoTicket;
import lotto.domain.entity.LottoTickets;
import lotto.domain.entity.Prize;
import lotto.domain.entity.PrizeEntry;
import lotto.domain.entity.WinningTicket;
import lotto.domain.entity.YieldRate;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoService {

  private static final int LOTTO_FEE = 1000;
  private static final int ONE = 1;
  private static final String CAN_NOT_PURCHASED = "로또를 구매할 수 없습니다.";

  private final LottoTicketCreator creator;

  public LottoService(LottoTicketCreator creator) {
    this.creator = creator;
  }

  public LottoTickets buyTheLottoTickets(Budget budget, LottoTickets ticketsByManual) {
    for(int i = 0; i < ticketsByManual.size(); i++) {
      budget.minusBudget(LOTTO_FEE);
    }

    LottoTickets ticketsByAuto = buyTheLottoTickets(budget);
    ticketsByAuto.addAll(ticketsByManual);
    return ticketsByAuto;
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

  public LottoResult getLottoResult(WinningTicket winningTicket, LottoTickets lottoTickets) {
    PrizeEntry prizeEntry = new PrizeEntry(calculatePrize(winningTicket, lottoTickets));
    YieldRate yieldRate = new YieldRate(calculateYieldRate(lottoTickets, prizeEntry));

    return new LottoResult(prizeEntry, yieldRate);
  }

  private Map<Prize, Integer> calculatePrize(WinningTicket winningTicket, LottoTickets lottoTickets) {
    Map<Prize, Integer> prizeMap = new EnumMap<>(Prize.class);
    Prize.inputValuesToMap(prizeMap);

    lottoTickets.getLottoList()
                .forEach(lottoTicket -> {
                  Prize prize = getPrize(winningTicket, lottoTicket);
                  if (prizeMap.containsKey(prize)) {
                    prizeMap.computeIfPresent(prize, (key, value) -> value + ONE);
                  }
                });
    return prizeMap;
  }

  private Prize getPrize(WinningTicket winningTicket, LottoTicket lottoTicket) {
    int matchedCount = lottoTicket.getMatchedCount(winningTicket);
    boolean matchedBonus = lottoTicket.isMatchedBonus(winningTicket.getBonusNumber());
    return Prize.valueOf(matchedCount, matchedBonus);
  }

  private double calculateYieldRate(LottoTickets lottoTickets, PrizeEntry prizeEntry) {
    int sumOfReward = prizeEntry.stream()
                                .mapToInt(entry -> entry.getKey().getReward() * entry.getValue())
                                .sum();

    return sumOfReward / ((double) LOTTO_FEE * lottoTickets.size());
  }

}
