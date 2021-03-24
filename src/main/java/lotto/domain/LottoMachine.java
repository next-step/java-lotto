package lotto.domain;

import java.util.HashSet;
import java.util.List;
import lotto.domain.generator.Generator;
import lotto.domain.generator.LottoGenerator;

public class LottoMachine {

  private List<Lotto> lottos;
  private static final String DUPLICATED_LOTTO = "중복된 로또는 발급할 수 없습니다.";

  public LottoMachine(Money money, Generator generator) {
    this.lottos = generator.composite(money);
    validateDuplicated(lottos);
  }
  public LottoMachine(List<Lotto> lottos) {
    validateDuplicated(lottos);
    this.lottos = lottos;
  }


  public void validateDuplicated(List<Lotto> lottoList) {
    boolean isNotDuplicated = lottoList.stream()
        .allMatch(new HashSet<>()::add);

    if (!isNotDuplicated) {
      throw new IllegalArgumentException(DUPLICATED_LOTTO);
    }
  }

  public LottoStaticResult makeMatchingCount(LastWinningLotto lastWeekWinningLotto) {
    LottoStaticResult lottoStaticResult = new LottoStaticResult();
    for (Lotto lotto : lottos) {
      lottoStaticResult.put(lastWeekWinningLotto.match(lotto));
    }
    return lottoStaticResult;
  }

  public int getLottoCount() {
    return lottos.size();
  }

  public List<Lotto> getLottoList() {
    return lottos;
  }
}
