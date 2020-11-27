package lotto.views;

import static java.util.stream.Collectors.toList;

import java.util.List;
import lotto.LottoNumberBundle;

public class DataImporter {

  private DataImporter() {
  }

  public static List<LottoNumberBundle> convertStringToBundle(List<String> rawInputs) {
    return rawInputs.stream()
        .map(LottoNumberBundle::of)
        .collect(toList());
  }
}
