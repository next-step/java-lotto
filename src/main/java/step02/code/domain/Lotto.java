package step02.code.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class Lotto {
  private static final int LOTTO_SIZE = 6;

  private final List<Number> lotto;

  public Lotto(List<Integer> lotto) {
    check(lotto);
    this.lotto = lotto.stream().map(Number::new).collect(Collectors.toList());
  }

  private void check(List<Integer> lotto) {
    if(lotto.size() != LOTTO_SIZE) {
      throw new IllegalArgumentException("lotto 는 6개의 숫자가 필요합니다");
    }
    Set<Integer> overlapRemoved = new HashSet<>(lotto);
    if(overlapRemoved.size() != LOTTO_SIZE) {
      throw new IllegalArgumentException("lotto 는 중복된 숫자를 가질수 없습니다");
    }
  }

  public int match(List<Number> winningNumber) {
    List<Number> lotto = new ArrayList<>(this.lotto);
    lotto.removeAll(winningNumber);
    return LOTTO_SIZE - lotto.size();
  }

  public List<Integer> lotto() {
    return lotto.stream()
      .map(Number::number)
      .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
  }
  
}
