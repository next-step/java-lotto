package lotto.domain;

import static java.util.Collections.shuffle;
import static java.util.Collections.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lotto.strategy.GenerateLottoNumber;

public class Lotto {

  private List<LottoNumber> lotto = new ArrayList<>();

  private List<LottoNumber> winLotto = new ArrayList<>();

  public Lotto() {
  }

  public Lotto(GenerateLottoNumber generateLottoNumber) {
    creatLotte(generateLottoNumber);
  }

  public Lotto(String[] winScoreArray) {

    for (String score : winScoreArray) {
      winLotto.add(new LottoNumber(Integer.parseInt(score)));
    }
    sort(winLotto);
  }

  public List<LottoNumber> getLotto() {
    return lotto;
  }

  public void creatLotte(GenerateLottoNumber generateLottoNumber) {

    List<LottoNumber> numberPull = generateLottoNumber.createNumberPull();
    shuffle(numberPull);

    lotto =  new ArrayList<>(numberPull.subList(0, 6));
    sort(lotto);
  }

  public List<LottoNumber> getWinLotto() {
    return winLotto;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Lotto lotto1 = (Lotto) o;
    return Objects.equals(getLotto(), lotto1.getLotto()) && Objects.equals(
        winLotto, lotto1.winLotto);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getLotto(), winLotto);
  }
}
