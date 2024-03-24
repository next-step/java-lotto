package lotto.domain;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos implements Iterable<Lotto> {

  private final List<Lotto> lottos;

  public Lottos(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public int size() {
    return this.lottos.size();
  }

  public Results results(Lottery lottery) {
    return new Results(this.lottos
            .stream()
            .map(lotto -> lotto.result(lottery))
            .collect(Collectors.toList()));
  }


  @Override
  public Iterator<Lotto> iterator() {
    return new LotteryIterator();
  }

  private class LotteryIterator implements Iterator<Lotto> {
    private int cursor = 0;

    @Override
    public boolean hasNext() {
      return cursor < lottos.size();
    }

    @Override
    public Lotto next() {;
      return lottos.get(cursor++);
    }
  }
}
