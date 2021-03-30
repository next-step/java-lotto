package step2.strategy;

import step2.domain.number.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRandomStrategy implements LottoStrategy {
  private static final int LOTTO_LENGTH = 6;
  private static final int FIRST_INDEX = 0;

  public LottoRandomStrategy() {

  }

  @Override
  public List<LottoNumber> markingNumbers(List<LottoNumber> lottoNumbers) {
    List<LottoNumber> pickedLottoNumbers = new ArrayList<>();
    List<LottoNumber> shuffleLottoNumbers = new ArrayList<>(lottoNumbers);
    for (int i = 0; i < LOTTO_LENGTH; i++) {
      Collections.shuffle(shuffleLottoNumbers);
      LottoNumber targetLottoNumber = shuffleLottoNumbers.get(FIRST_INDEX);
      pickedLottoNumbers.add(targetLottoNumber);
      shuffleLottoNumbers.remove(targetLottoNumber);
    }
    return pickedLottoNumbers;
  }
}
