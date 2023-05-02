package lotto3.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto3.domain.LottoTicket;
import lotto3.domain.Prize;

public class LottoResultCalculator {

  public static Map<Prize, Long> calculate(List<LottoTicket> tickets, List<Integer> winningNumbers) {
    List<Prize> prizes = new ArrayList<>();
    for (LottoTicket ticket : tickets) {
      int matchCount = ticket.matchCount(winningNumbers);
      Prize prize = Prize.valueOfMatchCount(matchCount);
      prizes.add(prize);
    }

    return convertMapWithPrize(prizes);
  }

  private static Map<Prize, Long> convertMapWithPrize(List<Prize> prizes) {
    return prizes.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }



}
