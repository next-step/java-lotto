package lotto.domain;

import lotto.domain.generator.LottoGenerator;
import lotto.domain.generator.ManualLottoGenerator;
import lotto.utils.LottoNumberParser;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoShop {

  private final LottoGenerator lottoGenerator;
  private final InputView inputView;

  public LottoShop(LottoGenerator lottoGenerator, InputView inputView) {
    this.lottoGenerator = lottoGenerator;
    this.inputView = inputView;
  }

  public Lottos buyLottos(PurchaseAmount purchaseAmount) {
    List<Lotto> manualLottos = generateManualLottos(purchaseAmount);
    List<Lotto> autoLottos = generateAutoLottos(purchaseAmount);
    return new Lottos(manualLottos, autoLottos);
  }

  private List<Lotto> generateManualLottos(PurchaseAmount purchaseAmount) {
    List<String> lottoNumbers = inputView.receiveManualLottos(purchaseAmount.getManualLottoCount());
    if (lottoNumbers.size() > purchaseAmount.getManualLottoCount()) {
      throw new IllegalArgumentException("수동으로 구매할 수 있는 횟수를 초과하였습니다.");
    }
    return lottoNumbers.stream()
            .map(LottoNumberParser::parse)
            .map(numbers -> new ManualLottoGenerator(numbers).generate())
            .collect(Collectors.toList());
  }

  private List<Lotto> generateAutoLottos(PurchaseAmount purchaseAmount) {
    List<Lotto> lottos = new ArrayList<>();
    for (int i = 0; i < purchaseAmount.getAutoLottoCount(); i++) {
      lottos.add(lottoGenerator.generate());
    }
    return lottos;
  }
}
