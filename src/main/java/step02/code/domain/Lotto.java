package step02.code.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


public class Lotto {
  private static final int LOTTO_SIZE = 6;

  private final List<Number> lotto;

  public Lotto(List<Integer> lotto) {
    this.lotto = lotto.stream().map(Number::new).collect(Collectors.toList());
    check(lotto);
  }

  public Lotto(MakeNumber makeNumber) {
    this(makeNumber.make());
  }

  public static Lotto makeLottoByString(String str) {
    isEmpty(str);
    List<Integer> lotto = Arrays.stream(str.split(","))
      .map(String::trim)
      .map(Lotto::check)
      .map(Integer::parseInt)
      .collect(Collectors.toList());
    return new Lotto(lotto);
  }

  public static void isEmpty(String str) {
    if(str == null || str.equals("")) {
      throw new IllegalArgumentException("null or 빈값이 들어올 수 없습니다.");
    }
  }

  public static String check(String str) {
    isEmpty(str);
    try {
      Integer.parseInt(str);
    } catch (Exception e) {
      throw new IllegalArgumentException("not int error");
    }
    return str;
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

  public List<Number> lotto() {
    return Collections.unmodifiableList(lotto);
  }
  

  @Override
  public boolean equals(Object o) {
    if (o == this)
        return true;
    if (!(o instanceof Lotto)) {
        return false;
    }
    Lotto lotto = (Lotto) o;
    return Objects.equals(this.lotto, lotto.lotto);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(lotto);
  }

}
