package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.message.Message;

public class Lotto implements Comparator<LottoNumber> {

  public static final int  LIMIT_INPUT_COUNT = 6;

  private final List<LottoNumber> lotto = new ArrayList<>();

  public Lotto(List<Integer> numberPull) {
    validation(numberPull);
    creatLotteNumber(numberPull);
  }

  private void validation(final List<Integer> numberPull) {
    checkInputCount(numberPull);
    checkDuplicateNumbers(numberPull);
  }

  public Lotto() {
  }

  private void checkDuplicateNumbers(final List<Integer> numberPull) {
    if(numberPull.size() != getDistinctNumberPullSize(numberPull)){
      throw new IllegalArgumentException(Message.MSG_ERROR_SAME_LOTTO_NUMBER);
    }
  }

  private long getDistinctNumberPullSize(final List<Integer> numberPull) {
    return numberPull.stream()
        .distinct()
        .count();
  }

  private void checkInputCount(final List<Integer> numberPull) {
    if(numberPull.size() != LIMIT_INPUT_COUNT){
      throw new IllegalArgumentException(Message.MSG_ERROR_INPUT_LOTTO_SIZE);
    }
  }

  public List<LottoNumber> getLotto() {
    return lotto;
  }

  private void creatLotteNumber(final List<Integer> numberPull) {
    numberPull.forEach(number -> lotto.add(new LottoNumber(number)));
    lotto.sort(this);
  }

  public int match(final LottoNumber lottoNumber) {
    return (int)lotto.stream()
        .filter(lottoNumber1 -> lottoNumber1.equals(lottoNumber))
        .count();
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