package lotto.domain;

import java.util.List;

public class LottoStore {

  private final static int LOTTO_AMOUNT = 1_000;

  public static Lottos buy(int buyQuantity, List<String> inputLottoNumbers) {

    List<Lotto> manualLottos = generateManualLottos(inputLottoNumbers);
    manualLottos.addAll(generateAutoLottos(buyQuantity - manualLottos.size()));
    return new Lottos(manualLottos);
  }

  private static List<Lotto> generateManualLottos(List<String> inputLottoNumbers) {

    LottoManualGenerator lottoManualGenerator = new LottoManualGenerator(inputLottoNumbers);
    return lottoManualGenerator.generate();
  }

  private static List<Lotto> generateAutoLottos(int quantity) {

    LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator(quantity);
    return lottoAutoGenerator.generate();
  }

  public static int quantity(Money buyMoney) {
    return buyMoney.buy(LOTTO_AMOUNT);
  }
}
