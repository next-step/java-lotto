package lotto.domain.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;

public class LottoNumberGenerator implements NumberGenerator {

  private static final List<Integer> lottoNumberCandidates = new ArrayList<>();

  static {
    for (int number = LottoNumber.MIN; number <= LottoNumber.MAX; number++) {
      lottoNumberCandidates.add(number);
    }
  }

  @Override
  public List<Integer> generate() {
    Collections.shuffle(lottoNumberCandidates);
    List<Integer> lottoNumbers = lottoNumberCandidates.subList(0, LottoGame.NUMBER_COUNT);
    Collections.sort(lottoNumbers);
    return lottoNumbers;
  }
}
