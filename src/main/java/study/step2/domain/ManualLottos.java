package study.step2.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ManualLottos {

  private final List<Lotto> lottos;

  public ManualLottos(List<String> inputText) {
    lottos = inputText.stream()
        .map(Lotto::new)
        .collect(Collectors.toList());
  }

  public List<Lotto> getLottos() {
    return lottos;
  }

  public void validatorPositiveLottos() {
    lottos.forEach(Lotto::validatorPositiveNumbers);
  }

  public void checkDuplicationLottos() {
    lottos.forEach(Lotto::checkDuplication);
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

  @Override
  public int hashCode() {
    return Objects.hash(lottos);
  }
}
