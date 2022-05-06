package lotto.domain.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

public class AutoLottoNumberGenerator implements NumberGenerator {

  private static final List<Integer> lottoNumberCandidates = new ArrayList<>();

  static {
    for (int number = LottoNumber.MIN; number <= LottoNumber.MAX; number++) {
      lottoNumberCandidates.add(number);
    }
  }

  @Override
  public List<Integer> generate() {
    Collections.shuffle(lottoNumberCandidates);
    List<Integer> lottoNumbers = lottoNumberCandidates.subList(0, LottoNumbers.NUMBER_COUNT);
    Collections.sort(lottoNumbers);
    return lottoNumbers;
  }
}
