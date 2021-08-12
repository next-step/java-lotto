package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.message.Message;

public class Lotto {

  public static final int LIMIT_INPUT_COUNT = 6;

  private final List<LottoNumber> lotto = new ArrayList<>();

  public Lotto(List<Integer> numberPull) {
    validation(numberPull);
    creatLotteNumber(numberPull);
  }

  private void validation(final List<Integer> numberPull) {
    checkInputCount(numberPull);
    checkDuplicateNumbers(numberPull);
  }

  private void checkDuplicateNumbers(final List<Integer> numberPull) {
    if (numberPull.size() != getDistinctNumberPullSize(numberPull)) {
      throw new IllegalArgumentException(Message.MSG_ERROR_SAME_LOTTO_NUMBER);
    }
  }

  private long getDistinctNumberPullSize(final List<Integer> numberPull) {
    return numberPull.stream()
        .distinct()
        .count();
  }

  private void checkInputCount(final List<Integer> numberPull) {
    if (numberPull.size() != LIMIT_INPUT_COUNT) {
      throw new IllegalArgumentException(Message.MSG_ERROR_INPUT_LOTTO_SIZE);
    }
  }

  private void creatLotteNumber(final List<Integer> numberPull) {
    Collections.sort(numberPull);
    numberPull.forEach(number -> lotto.add(new LottoNumber(number)));
  }

  public int matchCount(final LottoNumber lottoNumber) {
    return (int) lotto.stream()
        .filter(lottoNumber1 -> lottoNumber1.equals(lottoNumber))
        .count();
  }

  public int matchLotto(final Lotto lotto) {
    List<LottoNumber> list = new ArrayList<>(this.lotto);
    return list.stream().mapToInt(lotto::matchCount).sum();
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
    return Objects.equals(lotto, lotto1.lotto);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lotto);
  }

  @Override
  public String toString() {
    return this.lotto.stream().map(LottoNumber::toString)
        .collect(Collectors.toList()).toString();
  }

}