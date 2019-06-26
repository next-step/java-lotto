package lotto;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {

  private List<Lotto> lottos = new ArrayList<>();

  public Lottos(Quantity quantity) {
    makeLottos(quantity);
  }

  public Lottos(List<String> manualLottoNumbers) {
    manualLottoNumbers.stream()
        .forEach(numbers ->lottos.add(new Lotto(numbers)));
  }

  public Lottos(Lottos autoLottos, Lottos manualLottos) {
    lottos.addAll(autoLottos.getLottos());
    lottos.addAll(manualLottos.getLottos());
  }

  private void makeLottos(Quantity quantity) {
    for (int i = 0; i < quantity.getValue(); i++) {
      lottos.add(new Lotto());
    }
  }

  public List<LottoNumbers> getPurchasedLottoNumbers() {
    return lottos.stream().map(Lotto::getNumbers).collect(Collectors.toList());
  }

  public int getSameNumberCount(Lotto lastWeekWinLotto, int boundaryCount) {
    return (int) lottos.stream()
        .map(lotto -> lotto.countSameNumber(lastWeekWinLotto))
        .filter(value -> value == boundaryCount)
        .count();
  }

  public int getSameNumberCount(Lotto lastWeekWinLotto, int boundaryCount, int bonusNum) {
    return (int) lottos.stream()
        .map(lotto -> lotto.countSameNumber(lastWeekWinLotto))
        .filter(value -> value == boundaryCount)
        .filter(value -> value == boundaryCount)
        .count();
  }

  public Quantity getQuantity() {
    return new Quantity(lottos.size());
  }

  public List<Lotto> getLottos() {
    return unmodifiableList(lottos);
  }

}
