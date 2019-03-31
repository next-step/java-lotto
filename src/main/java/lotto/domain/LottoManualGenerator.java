package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoManualGenerator implements LottoGenerator {

  private List<String> inputLottoNumbers;

  public LottoManualGenerator(List<String> inputLottoNumbers) {
    this.inputLottoNumbers = inputLottoNumbers;
  }

  @Override
  public List<Lotto> generate() {

    return inputLottoNumbers.stream()
        .map(this::generateLotto)
        .collect(Collectors.toList());
  }

  public Lotto generateLotto(String inputLottoNumber) {

    return new Lotto(generateLottoNumbers(inputLottoNumber));
  }

  public static Set<LottoNumber> generateLottoNumbers(String inputLottoNumber) {

    String[] lottoNumbers = inputLottoNumber.split(",");
    return Arrays.stream(lottoNumbers)
        .filter(lottoNumber -> !lottoNumber.trim().isEmpty())
        .map(lottoNumber -> LottoNumber.getInstance(Integer.parseInt(lottoNumber.trim())))
        .collect(Collectors.toSet());
  }
}
