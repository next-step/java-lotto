package domain;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Lotteries implements Iterable<Lottery> {

  private final List<Lottery> lotteries;

  public Lotteries(List<Lottery> lotteries) {
    this.lotteries = lotteries;
  }

  public int size() {
    return this.lotteries.size();
  }

  public Results results(LotteryNumbers winningNumbers) {
    return new Results(this.lotteries
            .stream()
            .map(lottery -> lottery.result(winningNumbers))
            .collect(Collectors.toList()));
  }


  @Override
  public Iterator<Lottery> iterator() {
    return new LotteryIterator();
  }

  private class LotteryIterator implements Iterator<Lottery> {
    private int cursor = 0;
    @Override
    public boolean hasNext() {
      return cursor < lotteries.size();
    }

    @Override
    public Lottery next() {;
      return lotteries.get(cursor++);
    }
  }
}
