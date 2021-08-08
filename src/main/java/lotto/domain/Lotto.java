package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import lotto.message.Message;

public class Lotto implements Comparator<LottoNumber> {

  private final List<LottoNumber> lotto = new ArrayList<>();

  public Lotto(List<Integer> numberPull) {
    checkDuplicateNumbers(numberPull);
    creatLotteNumber(numberPull);
  }

  public Lotto() {
  }

  private void checkDuplicateNumbers(final List<Integer> numberPull) {
    if(numberPull.size() != numberPull.stream().distinct().count()){
      throw new IllegalArgumentException(Message.MSG_ERROR_SAME_LOTTO_NUMBER);
    }
  }

  public List<LottoNumber> getLotto() {
    return lotto;
  }

  private void creatLotteNumber(final List<Integer> numberPull) {
    numberPull.forEach(number -> lotto.add(new LottoNumber(number)));
    lotto.sort(this);
  }

  @Override
  public int compare(LottoNumber num1, LottoNumber num2) {
    return Integer.compare(num1.getNumber(), num2.getNumber());
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Lotto lotto1 = (Lotto) o;
    return Objects.equals(getLotto(), lotto1.getLotto());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getLotto());
  }
}