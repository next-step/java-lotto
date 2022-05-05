package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoGames;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoRewords;
import lotto.domain.strategy.AutoLottoNumberGenerator;
import lotto.domain.strategy.ManualLottoNumberGenerator;
import lotto.domain.strategy.NumberGenerator;
import lotto.view.LottoGameInputView;
import lotto.view.LottoGameOutputView;

public class LottoGameApp {

  public static void main(String[] args) {
    new LottoGameApp().start();
  }

  private void start() {
    LottoGameInputView lottoGameInputView = new LottoGameInputView();
    lottoGameInputView.setPurchaseAmount();
    lottoGameInputView.setManualAmount();
    lottoGameInputView.setManualNumbers();

    List<NumberGenerator> numberGenerators = makeNumberGenerators(
        lottoGameInputView.getAutoAmount(), lottoGameInputView.getManualAmount(),
        lottoGameInputView.getManualNumbers());
    LottoGames lottoGames = LottoGames.from(numberGenerators);

    LottoGameOutputView.printLottoPurchase(lottoGameInputView.getAutoAmount(),
        lottoGameInputView.getManualAmount());
    LottoGameOutputView.printLottoNumbers(lottoGames);
    lottoGameInputView.setWinNumbers();
    lottoGameInputView.setBonusBall();

    LottoRewords lottoRewords = lottoGames.draw(
        LottoNumbers.from(lottoGameInputView.getWinNumbers()),
        LottoNumber.from(lottoGameInputView.getBonusBallNumber()));

    LottoGameOutputView.printGameResult(lottoRewords);

  }

  private List<NumberGenerator> makeNumberGenerators(int auto, int manual,
      List<String> manualNumbers) {
    List<NumberGenerator> lottoNumberGenerators = new ArrayList<>();
    for (int i = 0; i < auto; i++) {
      lottoNumberGenerators.add(new AutoLottoNumberGenerator());
    }
    for (int i = 0; i < manual; i++) {
      lottoNumberGenerators.add(new ManualLottoNumberGenerator(manualNumbers.get(i)));
    }
    return lottoNumberGenerators;
  }
}
