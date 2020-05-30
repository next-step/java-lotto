package lotto.step4.domain;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Lottos {

  private final List<Lotto> lottos;

  private Lottos(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public static Lottos of (List<Lotto> lottos) {
    return new Lottos(lottos);
  }

  public long getPrice() {
    return lottos.size() * Lotto.PRICE;
  }

  public long getAutoLottosSize() {
    return stream()
            .filter(Lotto::isAuto)
            .count();
  }

  public long getDirectLottosSize() {
    return lottos.size() - getAutoLottosSize();
  }

  public Stream<Lotto> stream () {
    return lottos.stream();
  }

  public Prizes matches (WinningLotto winningLotto) {
    return Rank.stream()
               .map(rank -> Prize.of(rank, lottos.stream()
                                                 .map(winningLotto::getRankOfLotto)
                                                 .filter(rank::equals)
                                                 .count()))
               .collect(collectingAndThen(toList(), Prizes::of));
  }
}
