package lotto.service;

import java.util.List;
import lotto.model.Guest;
import lotto.model.Lotto;
import lotto.model.Store;
import lotto.util.AwardNumberUtil;

public class LottoService {

  public Guest visit(Guest guest, Store store) {
    return guest.choiceProduct(store);
  }

  public Lotto insertWinnerNumber(String winnerNumber) {
    return Lotto.from(AwardNumberUtil.getAwardNumberList(winnerNumber));
  }

  public void holdingLotteryTickets(List<Lotto> lotteryTickets, Lotto winLotto,
      int bonus) {


  }


  public double yieldCalculate(Long money, Long reward) {
    return (double) reward / money;
  }

  public Integer insertBonusNumber(int bonus) {
    return bonus;
  }
}
