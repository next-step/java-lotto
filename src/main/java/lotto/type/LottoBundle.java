package lotto.type;

import lotto.generator.LottoNumGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoBundle {
  private final List<LottoNumList> bundle;

  public static LottoBundle generate(int lottoCount, LottoNumGenerator lottoNumGenerator) {
    return new LottoBundle(lottoCount, lottoNumGenerator);
  }

  public static LottoBundle valueOf(List<LottoNumList> bundle) {
    return new LottoBundle(bundle);
  }

  private LottoBundle(int lottoCount, LottoNumGenerator lottoNumGenerator) {
    this(generateBundle(lottoCount, lottoNumGenerator));
  }

  private LottoBundle(List<LottoNumList> bundle) {
    this.bundle = bundle;
  }

  private static List<LottoNumList> generateBundle(int lottoCount, LottoNumGenerator lottoNumGenerator) {
    List<LottoNumList> lottoBundle = new ArrayList<>();
    for (int i = 0; i < lottoCount; i++) {
      lottoBundle.add(lottoNumGenerator.generate());
    }
    return lottoBundle;
  }

  public List<LottoPrize> getLottoPrizes(WinningNums winningNums) {
    return bundle.stream()
        .map(lottoNumList -> LottoPrize.findByMatchCount(lottoNumList.getMatchCount(winningNums)))
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
        .map(LottoNumList::toString)
        .collect(Collectors.joining("\n"));
  }
}
