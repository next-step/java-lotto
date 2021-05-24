package study.step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ManualLottos {

  private final List<Lotto> lottos;

  public ManualLottos(List<String> inputText) {
    List<Lotto> list = new ArrayList<>();

    inputText.stream().map(Lotto::new).forEach(lotto -> {
      lotto.checkDuplication();
      list.add(lotto);
    });

    lottos = list;
  }

  public List<Lotto> getLottos() {
    return lottos;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ManualLottos that = (ManualLottos) o;
    return Objects.equals(lottos, that.lottos);
  }

}
