package lotto.domain;

import lotto.domain.generator.LottoGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

  private final LottoGenerator lottoGenerator;
  private final InputView inputView;

  public LottoShop(LottoGenerator lottoGenerator, InputView inputView) {
    this.lottoGenerator = lottoGenerator;
    this.inputView = inputView;
  }

  public Lottos buyLottos(int count) {
    List<Lotto> manualLottos = generateManualLottos(count);
    List<Lotto> autoLottos = generateLottos(count - manualLottos.size());
    return new Lottos(manualLottos, autoLottos);
  }

  private List<Lotto> generateManualLottos(int maxCount) {
    List<Lotto> lottos = inputView.receiveManualLottos();
    if (lottos.size() > maxCount) {
      throw new IllegalArgumentException("수동으로 구매할 수 있는 횟수를 초과하였습니다.");
    }
    return lottos;
  }

  private List<Lotto> generateLottos(int count) {
    List<Lotto> lottos = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      lottos.add(lottoGenerator.generate());
    }
    return lottos;
  }
}
