package lotto.domain;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

  private static final int LOTTO_SIZE = 6;
  private static final String INVALID_SIZE_MESSAGE = "하나의 로또는 중복되지 않은 6개의 숫자를 가져야합니다.";

  private final Set<LottoNumber> values;

  public Lotto(Set<LottoNumber> values) {
    validate(values);
    this.values = values;
  }

  public static Lotto createLotto(Set<Integer> values) {
    Set<LottoNumber> lottoNumbers = values.stream()
        .map(LottoNumber::new)
        .collect(Collectors.toSet());
    return new Lotto(lottoNumbers);
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
