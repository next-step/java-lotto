package lotto.model;

import java.util.List;
import lotto.enums.Grade;

public final class LotteryNoteCounter {
  private final List<Lotto> lotteryTickets;
  public LotteryNoteCounter(List<Lotto> lotteryTickets) {
    this.lotteryTickets = lotteryTickets;
  }

  public int lotteryCount(Grade grade) {
    int count = 0;
    for (Lotto lotto : lotteryTickets) {
      count = getCount(grade, count, lotto);
    }
    return count;
  }

  private int getCount(Grade grade, int count, Lotto lotto) {
    if(lotto.currentGrade() == grade) {
      count++;
    }
    return count;
  }
}
