package lotto.type;

import lotto.strategy.pick.RandomNumberPickStrategy;
import lotto.strategy.shuffle.ShuffleStrategy;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersBundle {
  private final List<LottoNumbers> bundle;

  public LottoNumbersBundle(List<LottoNumbers> bundle) {
    this.bundle = bundle;
  }

  public LottoNumbersBundle(int lottoCount, RandomNumberPickStrategy randomNumberPickStrategy, ShuffleStrategy shuffleStrategy) {
    this(IntStream.range(0, lottoCount)
        .mapToObj(i -> LottoNumbers.generate(shuffleStrategy, randomNumberPickStrategy))
        .collect(java.util.stream.Collectors.toList()));
  }

  public List<LottoPrize> getLottoPrizes(LottoNumbers winningNumbers, LottoNumber bonusLottoNumber) {
    if (winningNumbers.contains(bonusLottoNumber)) {
      throw new IllegalArgumentException("당첨번호와 보너스 볼의 번호가 중복된 것이 있습니다.");
    }

    return bundle.stream()
        .map(lottoNumList -> LottoPrize.findByMatchCount(lottoNumList.getMatchCount(winningNumbers), lottoNumList.isMatch(bonusLottoNumber)))
        .collect(Collectors.toList());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoNumbersBundle bundle1 = (LottoNumbersBundle) o;
    return Objects.equals(bundle, bundle1.bundle);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(bundle);
  }

  @Override
  public String toString() {
    return bundle.stream()
        .map(LottoNumbers::toString)
        .collect(Collectors.joining("\n"));
  }
}
