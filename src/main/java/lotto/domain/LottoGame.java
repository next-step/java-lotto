package lotto.domain;

import java.util.List;

public class LottoGame {

  public static final int LOTTO_TICKET_PRICE = 1000;

  public static long toTicketCount(Money money) {
    return money.divide(LOTTO_TICKET_PRICE).getAmount();
  }

  public static Rank match(List<Integer> lottoNumbers, List<Integer> winLottoNumbers,
      Integer bonusNumber) {
    return Rank.of(getMatchCount(lottoNumbers, winLottoNumbers),
        lottoNumbers.contains(bonusNumber));
  }

  private static long getMatchCount(List<Integer> lottoNumbers, List<Integer> winLottoNumbers) {
    return lottoNumbers.stream()
        .filter(winLottoNumbers::contains)
        .count();
  }
}
