package lotto.type;

import lotto.generator.LottoNumGenerator;
import lotto.generator.ShuffleStrategy;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoBundle {
  private final List<LottoNums> bundle;

  private LottoBundle(int lottoCount, LottoNumGenerator lottoNumGenerator, ShuffleStrategy shuffleStrategy) {
    this(IntStream.range(0, lottoCount)
        .mapToObj(i -> lottoNumGenerator.generate(shuffleStrategy))
        .collect(java.util.stream.Collectors.toList()));
  }

  private LottoBundle(List<LottoNums> bundle) {
    this.bundle = bundle;
  }

  public static LottoBundle generate(int lottoCount, LottoNumGenerator lottoNumGenerator, ShuffleStrategy shuffleStrategy) {
    return new LottoBundle(lottoCount, lottoNumGenerator, shuffleStrategy);
  }

  public static LottoBundle valueOf(List<LottoNums> bundle) {
    return new LottoBundle(bundle);
  }

  public List<LottoPrize> getLottoPrizes(WinningNums winningNums, BonusNum bonusNum) {
    return bundle.stream()
        .map(lottoNumList -> LottoPrize.findByMatchCount(lottoNumList.getMatchCount(winningNums), lottoNumList.isMatch(bonusNum)))
        .collect(Collectors.toList());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoBundle bundle1 = (LottoBundle) o;
    return Objects.equals(bundle, bundle1.bundle);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(bundle);
  }

  @Override
  public String toString() {
    return bundle.stream()
        .map(LottoNums::toString)
        .collect(Collectors.joining("\n"));
  }
}
