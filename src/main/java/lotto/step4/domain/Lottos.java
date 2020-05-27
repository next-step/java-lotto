package lotto.step4.domain;

import java.util.List;
import java.util.stream.Stream;

public class Lottos {

  private final List<Lotto> autoLottos, directLottos;

  private Lottos(List<Lotto> directLottos, List<Lotto> autoLottos) {
    this.directLottos = directLottos;
    this.autoLottos = autoLottos;
  }

  public static Lottos of (List<Lotto> directLottos, List<Lotto> autoLottos) {
    return new Lottos(directLottos, autoLottos);
  }

  public long getPrice() {
    return stream().count() * Lotto.PRICE;
  }

  public long getAutoLottosSize() {
    return autoLottos.size();
  }

  public long getDirectLottosSize() {
    return directLottos.size();
  }

  public Stream<Lotto> stream () {
    return Stream.concat(directLottos.stream(), autoLottos.stream());
  }

}
