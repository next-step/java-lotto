package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.WinningResultDto;
import lotto.enums.Grade;
import lotto.model.Guest;
import lotto.model.Lotto;
import lotto.model.Reward;
import lotto.model.Store;
import lotto.util.AwardNumberUtil;

public class LottoService {

  public Guest visit(Guest guest, Store store) {
    return guest.choiceProduct(store);
  }

  public Lotto insertWinnerNumber(String winnerNumber) {
    return Lotto.from(AwardNumberUtil.getAwadNumberList(winnerNumber));
  }

  public List<WinningResultDto> histories(List<Lotto> lotteryTickets, Lotto winLotto) {
    List<WinningResultDto> histories = new ArrayList<>();
    for (Lotto lotto : lotteryTickets) {
      histories.add(new WinningResultDto(
          Grade.valueOf(Reward.matchCount(lotto.numbers(), winLotto.numbers()), false)));
    }
    return histories;
  }

  public Long allAddReward(List<WinningResultDto> histories) {
    long result = 0L;
    for (WinningResultDto history : histories) {
      result += (history.getGrade().getAwardPrice() * 100);
    }
    return result;
  }

  public double yieldCalculate(Long money, Long reward) {
    return (double) reward / money;
  }
}
