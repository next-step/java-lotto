package lotto;

import java.util.List;

public class Store {

  public static Lottos buyAutoLottos(Quantity quantity) {
    return new Lottos(quantity);
  }

  public static Lottos buyManualLottos(List<String> manualLottoNumbers) {
    return new Lottos(manualLottoNumbers);
  }

  public static Lottos buyLottos(Quantity autoQuantity, List<String> manualLottoNumbers) {
    if(isEmpty(manualLottoNumbers)) {
      return buyAutoLottos(autoQuantity);
    }
    Lottos autoLottos = buyAutoLottos(autoQuantity);
    Lottos manualLottos = buyManualLottos(manualLottoNumbers);
    return new Lottos(autoLottos,manualLottos);
  }

  private static boolean isEmpty(List<String> manualLottoNumbers) {
    return manualLottoNumbers == null || manualLottoNumbers.size()==0;
  }
}
