package lotto.domain;

import static java.util.Collections.shuffle;
import static java.util.Collections.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import lotto.message.Message;
import lotto.strategy.GenerateLottoNumber;

public class Lotto  implements Comparator<LottoNumber> {

  private List<LottoNumber> lotto = new ArrayList<>();

  private List<LottoNumber> winLotto = new ArrayList<>();

  public static final int START_INDEX = 0;

  public static final int END_INDEX = 6;

  public Lotto() {
  }

  public Lotto(GenerateLottoNumber generateLottoNumber) {
    creatLotte(generateLottoNumber);
  }

  public Lotto(String[] winScoreArray) {

    for (String score : winScoreArray) {
      checkDuplicateNumbers(Integer.parseInt(score.trim()));
      winLotto.add(new LottoNumber(Integer.parseInt(score.trim())));
    }
    sort(winLotto, new LottoNumber());
  }

  private void checkDuplicateNumbers(int targetNumber) {

    if(winLotto.contains(new LottoNumber(targetNumber))){
      throw new IllegalArgumentException(Message.MSG_ERROR_SAME_LOTTO_NUMBER);
    }
  }

  public List<LottoNumber> getLotto() {
    return lotto;
  }

  public void creatLotte(GenerateLottoNumber generateLottoNumber) {

    List<LottoNumber> numberPull = generateLottoNumber.createNumberPull();
    shuffle(numberPull);

    lotto =  new ArrayList<>(numberPull.subList(START_INDEX, END_INDEX));
    sort(lotto, new LottoNumber());
  }

  public List<LottoNumber> getWinLotto() {
    return winLotto;
  }

  @Override
  public int compare(LottoNumber num1, LottoNumber num2) {
    return Integer.compare(num1.getNumber(), num2.getNumber());
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
    return Objects.equals(getWinLotto(), lotto1.getWinLotto()) && Objects.equals(
        getLotto(), lotto1.getLotto());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getWinLotto(), getLotto());
  }
}
