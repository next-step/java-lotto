import domain.Lotto;
import domain.LottoNumber;
import domain.LottoResult;
import domain.Lottos;
import domain.Wallet;
import view.LottoInputView;
import view.LottoResultView;

import java.util.List;

public class main {

  public static void main(String[] args) {
    int moneyAmount = LottoInputView.inputMoney();

    Wallet wallet = new Wallet(moneyAmount);
    wallet.buyLottos();

    Lottos boughtLottos = wallet.getLottos();
    int boughtLottosAmount = boughtLottos.getLottoCountAmount();
    LottoResultView.showBoughtLottoAmount(boughtLottosAmount);
    LottoResultView.showLottos(boughtLottos);


    List<LottoNumber> lastWeekWinningNumbers = LottoInputView.inputLastWeekWinningNumbers();
    Lotto lastWeekWinningLotto = new Lotto(lastWeekWinningNumbers);

    LottoResult lottoResult = new LottoResult(boughtLottos, lastWeekWinningLotto);
    LottoResultView.showLottoStatistics(lottoResult);
    LottoResultView.showLottoProfit(boughtLottosAmount, lottoResult.totalLottoPrize());
  }

}
