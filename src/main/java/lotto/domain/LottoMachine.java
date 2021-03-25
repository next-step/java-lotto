package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lotto.domain.generator.AutoLottoGenerator;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.generator.ManualLottoGenerator;
import lotto.domain.generator.MergedGenerator;

public class LottoMachine {

  private List<Lotto> lottos;
  private Money money;
  private static final String DUPLICATED_LOTTO = "중복된 로또는 발급할 수 없습니다.";

  public LottoMachine(Money money) {
    this(money,new ArrayList<>());
  }

  public LottoMachine(int money) {
    this(new Money(money),new ArrayList<>());
  }

  public LottoMachine(Money money, List<Lotto> lottos) {
    this.money = money;
    this.lottos = lottos;
  }

  public void makeLottos(List<List<Integer>> manualLottos) {
    List<LottoGenerator> generators = new ArrayList<>();
    generators.add(new ManualLottoGenerator(manualLottos));
    money.decreaseByManualLottoCount(manualLottos.size());
    generators.add(new AutoLottoGenerator(money.calculateLottoCount()));
    LottoGenerator lottoGenerator = new MergedGenerator(generators);
    this.lottos = lottoGenerator.generatedLottoList();
    validateDuplicated(this.lottos);
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
