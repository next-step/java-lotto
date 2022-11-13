package nextstep.lotto;

import java.util.Set;
import java.util.TreeSet;

public class Lotto {

  private final Set<LottoNumber> numbers;

  public Lotto(final Set<LottoNumber> numbers) {
    if (numbers == null || numbers.size() != 6) {
      throw new IllegalArgumentException("로또 게임은 6개의 로또 넘버로 생성됩니다.");
    }
    this.numbers = new TreeSet<>(numbers) {
    };
  }

  public Lotto(int number1, int number2, int number3, int number4, int number5, int number6) {
    this(
      Set.of(
        LottoNumber.lottoNumber(number1),
        LottoNumber.lottoNumber(number2),
        LottoNumber.lottoNumber(number3),
        LottoNumber.lottoNumber(number4),
        LottoNumber.lottoNumber(number5),
        LottoNumber.lottoNumber(number6)
      )
    );
  }

  @Override
  public String toString() {
    return numbers.toString();
  }

  public int match(final Lotto other) {
    final Set<LottoNumber> retains = new TreeSet<>(this.numbers);
    retains.retainAll(other.numbers);
    return retains.size();
  }
}
