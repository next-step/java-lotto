package lotto.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoMachine {

  private LottoMachine() {
  }

  public static Lotto one() {
    return Lotto.defaultOf();
  }

  public static Lottos sell(int size) {
    List<Lotto> auto = auto(size);
    return Lottos.of(auto);
  }
  public static Lottos manualLottos(List<String> manualLottoNumbers ) {
    List<Lotto> manual = manual(manualLottoNumbers);
    return Lottos.of(manual);
  }

  private static List<Lotto> auto(int size) {
    List<Lotto> lottos = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      lottos.add(Lotto.defaultOf());
    }
    return lottos;
  }

  private static List<Lotto> manual(List<String> manualLottoNumbers) {
    if (Objects.isNull(manualLottoNumbers)) {
      return new ArrayList<>();
    }
    return manualLottoNumbers.stream()
                              .map(Lotto::defaultOf)
                              .collect(Collectors.toList());
  }
}
