package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Number;

public class AutoLottoNumberGenerateStrategy implements LottoNumberGenerateStrategy {

  private static final int LOTTO_SIZE = 6;

  @Override
  public List<Number> generate() {
    List<Number> numberList =  new ArrayList<>();
    LottoNumberGenerator lottoNumberGenerator = LottoNumberGenerator.createLottoNumbers();
    Collections.shuffle(lottoNumberGenerator.getLottos());

    for(int i = 0; i < LOTTO_SIZE; i++) {
      numberList.add(Number.generateNumber(lottoNumberGenerator.getOne(i)));
    }
    return numberList;
  }
}
