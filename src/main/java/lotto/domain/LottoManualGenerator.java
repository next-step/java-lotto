package lotto.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoManualGenerator implements LottoGenerator {

  @Override
  public Lotto generate() {
    return null;
  }

  public Set<LottoNumber> generateLottoNumbers(String inputLottoNumbers) {

    String[] lottoNumbers = inputLottoNumbers.split(",");
    return Arrays.stream(lottoNumbers)
        .filter(lottoNumber -> !lottoNumber.trim().isEmpty())
        .map(lottoNumber -> LottoNumber.getInstance(Integer.parseInt(lottoNumber.trim())))
        .collect(Collectors.toSet());
  }

  public Lotto generate(String inputLottoNumbers) {
    return new Lotto(generateLottoNumbers(inputLottoNumbers));
  }
}
