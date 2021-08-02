package lotto.domain;

import static java.util.Collections.shuffle;
import static java.util.Collections.sort;

import java.util.ArrayList;
import java.util.List;
import lotto.strategy.GenerateLottoNumber;
import lotto.strategy.RealGenerateLottoNumber;

public class Lotto {

  private List<LottoNumber> lotto = new ArrayList<>();

  public Lotto() {
  }

  public List<LottoNumber> getLotto() {
    return lotto;
  }

  public void creatLotte(GenerateLottoNumber generateLottoNumber) {
    generateLottoNumber = new RealGenerateLottoNumber(1,46);
    List<LottoNumber> numberPull = generateLottoNumber.createNumberPull();
    shuffle(numberPull);

    lotto =  new ArrayList<>(numberPull.subList(0, 6));
    sort(lotto);
  }
}
