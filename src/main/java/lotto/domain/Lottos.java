package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Lottos {

  public static final int LOTTO_PRICE = 1_000;

  private final List<Lotto> lottos;
  private final int manualCount;
  private final int autoCount;

  private Lottos(List<Lotto> lottos, int manualCount, int autoCount) {
    this.lottos = lottos;
    this.manualCount = manualCount;
    this.autoCount = autoCount;
  }

  public static Lottos of(int purchaseAmount, List<List<Integer>> manualLottoNumbers) {
    int manualCount = manualLottoNumbers.size();
    int totalCount = purchaseAmount / LOTTO_PRICE;
    int autoCount = totalCount - manualCount;

    List<Lotto> allLottos = new ArrayList<>();

    for (List<Integer> numbers : manualLottoNumbers) {
      allLottos.add(new Lotto(new FixedDrawingStrategy(numbers)));
    }

    for (int i = 0; i < autoCount; i++) {
      allLottos.add(new Lotto(new RandomDrawingStrategy()));
    }

    return new Lottos(allLottos, manualCount, autoCount);
  }

  public int getManualCount() {
    return manualCount;
  }

  public int getAutoCount() {
    return autoCount;
  }

  public void forEach(Consumer<Lotto> action) {
    lottos.forEach(action);
  }

  public WinningResult analyze(WinningLotto winningLotto) {
    return WinningResult.of(this.lottos, winningLotto);
  }

}
