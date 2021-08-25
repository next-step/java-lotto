package step2.model.LottoStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import step2.model.Lotto.Lotto;
import step2.model.Lotto.LottoNo;
import step2.model.Lotto.LottoNos;
import step2.model.Lotto.Lottos;
import step2.model.view.Input;

public class LottoStore {

  private static final int LOTTO_PICAKABLE_NUMBERS = 6;
  private static final int LOTTO_LARGEST_NUMBER = 45;
  private static final int LOTTO_PRICE = 1000;

  public Lottos purchase(Input userInput) {

    List<Lotto> lottos = new ArrayList<>();

    int userAutoLottoAmount =
        userInput.getUserAmount() - (userInput.getUserManualLottoNumbers().size() * LOTTO_PRICE);

    lottos.addAll(purchaseAutoLottos(userAutoLottoAmount));
    lottos.addAll(purchaseManualLottos(userInput.getUserManualLottoNumbers()));

    return new Lottos(lottos);
  }

  public List<Lotto> purchaseAutoLottos(int userAmount) {
    List<Lotto> lottos = new ArrayList<>();

    for (int i = 0; i < userAmount; i += LOTTO_PRICE) {
      lottos.add(new Lotto(getLottoRandomNumbers()));
    }

    return lottos;
  }

  public List<Lotto> purchaseManualLottos(List<LottoNos> lottoNumbers) {
    List<Lotto> lottos = new ArrayList<>();

    for (LottoNos lottoNos : lottoNumbers) {
      lottos.add(new Lotto(lottoNos));
    }

    return lottos;
  }

  private LottoNos getLottoRandomNumbers() {
    List<LottoNo> lottoNumbers = new ArrayList();

    for (int i = 0; i < LOTTO_PICAKABLE_NUMBERS; i++) {
      lottoNumbers.add(getLottoNoWithRandom(lottoNumbers));
    }

    return new LottoNos(lottoNumbers);
  }

  private LottoNo getLottoNoWithRandom(List<LottoNo> lottoNoList) {
    LottoNo lottoNo;
    int randomNum;
    do {
      randomNum = new Random().nextInt(LOTTO_LARGEST_NUMBER) + 1;
      lottoNo = new LottoNo(randomNum);
    } while (lottoNoList.contains(lottoNo));

    return lottoNo;
  }

  public LottoWin draw(Lottos lottos, Input userInput) {
    LottoWin lottoWin = new LottoWin(userInput.getLottowinningNumbers(),
        userInput.getLottowinningBonusNumbers());
    return lottoWin.draw(lottos);
  }
}
