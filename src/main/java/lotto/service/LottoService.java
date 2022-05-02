package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.WinningResultDto;
import lotto.enums.Grade;
import lotto.model.Guest;
import lotto.model.LotteryNoteCounter;
import lotto.model.Lotto;
import lotto.model.Store;
import lotto.util.AwardNumberUtil;

public class LottoService {

  public Guest visit(Guest guest, Store store) {
    return guest.choiceProduct(store);
  }

  public Lotto insertWinnerNumber(String winnerNumber) {
    return Lotto.from(AwardNumberUtil.getAwadNumberList(winnerNumber));
  }

  public List<Lotto> allLotteryTickets(List<Lotto> lotteryTickets, Lotto winLotto) {
    List<Lotto> LotteryTickets = new ArrayList<>();
    for (Lotto lotto : lotteryTickets) {
      LotteryTickets.add(
          lotto.reflectLottoGrade(AwardNumberUtil.matchCount(lotto.numbers(), winLotto.numbers()), false));
    }
    return LotteryTickets;
  }

  public List<WinningResultDto> histories(List<Lotto> lotteryTickets) {
    List<WinningResultDto> histories = new ArrayList<>();
    LotteryNoteCounter lotteryNoteCount = new LotteryNoteCounter(lotteryTickets);
    for (Grade grade : Grade.values()) {
      histories.add(new WinningResultDto(grade, lotteryNoteCount.lotteryCount(grade)));
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
