package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoGames;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoRewords;
import lotto.domain.strategy.LottoNumberGenerator;
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

    LottoGames lottoGames = LottoGames.from(
        makeNumberGenerators(lottoGameInputView.getPurchaseAmount()));

    LottoGameOutputView.printLottoNumbers(lottoGames);
    lottoGameInputView.setWinNumbers();
    lottoGameInputView.setBonusBall();

    LottoRewords lottoRewords = lottoGames.draw(
        LottoNumbers.from(lottoGameInputView.getWinNumbers()),
        LottoNumber.from(lottoGameInputView.getBonusBallNumber()));

    LottoGameOutputView.printGameResult(lottoRewords);

  }

  private List<NumberGenerator> makeNumberGenerators(int purchaseAmount) {
    List<NumberGenerator> lottoNumberGenerators = new ArrayList<>();
    for (int i = 0; i < purchaseAmount; i++) {
      lottoNumberGenerators.add(new LottoNumberGenerator());
    }
    return lottoNumberGenerators;
  }
}
