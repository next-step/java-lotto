import domain.LottoNumber;
import domain.LottoResult;
import domain.Lottos;
import domain.Wallet;
import domain.WinningLotto;
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
    int lastWeekBonusNumber = LottoInputView.inputLastWeekBonusNumber();
    WinningLotto lastWeekWinningLotto = new WinningLotto(lastWeekWinningNumbers, new LottoNumber(lastWeekBonusNumber));

    LottoResult lottoResult = new LottoResult(boughtLottos, lastWeekWinningLotto);
    LottoResultView.showLottoStatistics(lottoResult);
    LottoResultView.showLottoProfit(boughtLottosAmount, lottoResult.totalLottoPrize());
  }

}
