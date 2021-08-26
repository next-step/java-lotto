package step2.model.lottostore;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import step2.model.lotto.Lotto;
import step2.model.lotto.LottoNo;
import step2.model.lotto.LottoNos;
import step2.model.lotto.Lottos;
import step2.model.view.Input;

public class LottoStore {

  private static final int LOTTO_PICAKABLE_NUMBERS = 6;
  private static final int LOTTO_LARGEST_NUMBER = 45;
  private static final int LOTTO_PRICE = 1000;

  public Lottos purchase(int userAmount, List<LottoNos> userManualLottoNumbers) {

    List<Lotto> lottos = new ArrayList<>();

    int userAutoLottoAmount = userAmount - (userManualLottoNumbers.size() * LOTTO_PRICE);

    lottos.addAll(purchaseAutoLottos(userAutoLottoAmount));
    lottos.addAll(purchaseManualLottos(userManualLottoNumbers));

    return new Lottos(lottos);
  }

  private List<Lotto> purchaseAutoLottos(int userAmount) {
    List<Lotto> lottos = new ArrayList<>();

    for (int i = 0; i < userAmount; i += LOTTO_PRICE) {
      lottos.add(new Lotto(getLottoRandomNumbers()));
    }

    return lottos;
  }

  private List<Lotto> purchaseManualLottos(List<LottoNos> lottoNumbers) {
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
