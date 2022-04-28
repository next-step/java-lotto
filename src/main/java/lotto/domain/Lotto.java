package lotto.domain;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {

  private static final int LOTTO_SIZE = 6;
  private static final String INVALID_SIZE_MESSAGE = "하나의 로또는 중복되지 않은 6개의 숫자를 가져야합니다.";

  private final Set<LottoNumber> values = new TreeSet<>();

  public Lotto(Set<LottoNumber> values) {
    validate(values);
    this.values.addAll(values);
  }

  public static Lotto create(Set<Integer> values) {
    return values.stream()
        .map(LottoNumber::new)
        .collect(Collectors.collectingAndThen(Collectors.toSet(), Lotto::new));
  }

  public static Lotto autoCreate() {
    return create(LottoNumberGenerator.getRandomIntegers());
  }

  public Set<LottoNumber> getValues() {
    return values;
  }

  public Rank getRank(WinningLotto winningLotto) {
    boolean matchBonus = winningLotto.matchBonus(this);
    return Rank.valueOf(getInterSectionSize(winningLotto.getLotto()), matchBonus);
  }

  public boolean contains(LottoNumber number) {
    return values.contains(number);
  }

  private int getInterSectionSize(Lotto other) {
    Set<LottoNumber> intersection = new TreeSet<>(values);
    intersection.retainAll(other.values);
    return intersection.size();
  }

  private void validate(Set<LottoNumber> values) {
    if (values.size() != LOTTO_SIZE) {
      throw new IllegalArgumentException(INVALID_SIZE_MESSAGE);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Lotto lotto = (Lotto) o;
    return Objects.equals(values, lotto.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }
}
