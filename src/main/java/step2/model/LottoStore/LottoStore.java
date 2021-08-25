package step2.model.LottoStore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import step2.model.Lotto.Lotto;
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

  public List<Lotto> purchaseManualLottos(List<List<Integer>> lottoNumbers) {
    List<Lotto> lottos = new ArrayList<>();

    for (List<Integer> lottoNumber : lottoNumbers) {
      lottos.add(new Lotto(lottoNumber));
    }

    return lottos;
  }

  private List<Integer> getLottoRandomNumbers() {
    List lottoNumbers = new ArrayList();
    for (int i = 0; i < LOTTO_PICAKABLE_NUMBERS; i++) {
      lottoNumbers.add(getRandomNum(lottoNumbers));
    }

    Collections.shuffle(lottoNumbers);
    Collections.sort(lottoNumbers);

    return lottoNumbers;
  }

  private int getRandomNum(List<Integer> lottoNumbers) {
    int randomNum;
    do {
      randomNum = new Random().nextInt(LOTTO_LARGEST_NUMBER) + 1;
    } while (lottoNumbers.contains(randomNum));

    return randomNum;
  }

  public LottoWin draw(Lottos lottos, Input userInput) {
    LottoWin lottoWin = new LottoWin(userInput.getLottowinningNumbers(),
        userInput.getLottowinningBonusNumbers());
    return lottoWin.draw(lottos);
  }
}
