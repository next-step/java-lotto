package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoDrawResults;
import lotto.domain.LottoGames;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
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

    LottoGames lottoGames = LottoGames.of(
        makeNumberGenerators(lottoGameInputView.getPurchaseAmount()));

    LottoGameOutputView.printLottoNumbers(lottoGames);
    lottoGameInputView.setWinNumbers();
    lottoGameInputView.setBonusBall();

    LottoDrawResults lottoDrawResults = lottoGames.draw(
        LottoNumbers.of(lottoGameInputView.getWinNumbers()),
        LottoNumber.of(lottoGameInputView.getBonusBallNumber()));

    LottoGameOutputView.printGameResult(lottoDrawResults);

  }

  private List<NumberGenerator> makeNumberGenerators(int purchaseAmount) {
    List<NumberGenerator> lottoNumberGenerators = new ArrayList<>();
    for (int i = 0; i < purchaseAmount; i++) {
      lottoNumberGenerators.add(new LottoNumberGenerator());
    }
    return lottoNumberGenerators;
  }
}
