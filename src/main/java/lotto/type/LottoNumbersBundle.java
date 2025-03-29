package lotto.type;

import lotto.LottoCreateStrategyContext;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersBundle {
  private final List<LottoNumbers> bundle;

  public LottoNumbersBundle(List<LottoNumbers> bundle) {
    this.bundle = bundle;
  }

  public LottoNumbersBundle(
      int lottoCount,
      LottoCreateStrategyContext lottoCreateStrategyContext
  ) {
    this(
        IntStream.range(0, lottoCount)
            .mapToObj(i -> LottoNumbers.generate(lottoCreateStrategyContext.getShuffleStrategy(), lottoCreateStrategyContext.getNumberPickStrategy()))
            .collect(Collectors.toList())
    );
  }

  public LottoNumbersBundle(
      int toCreateLottoNumbersCount,
      List<String> manualCreatedLottoNumbersBundle,
      LottoCreateStrategyContext lottoCreateStrategyContext
  ) {
    if (toCreateLottoNumbersCount < 0) {
      throw new IllegalArgumentException("총 구매한 로또수 보다 수동으로 입력한 값이 많습니다.");
    }

    List<LottoNumbers> res = manualCreatedLottoNumbersBundle.stream().map(LottoNumbers::new).collect(Collectors.toList());

    res.addAll(
        IntStream.range(0, toCreateLottoNumbersCount)
            .mapToObj(i -> LottoNumbers.generate(lottoCreateStrategyContext.getShuffleStrategy(), lottoCreateStrategyContext.getNumberPickStrategy()))
            .collect(Collectors.toList())
    );

    this.bundle = res;
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
