package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class Main {
  public static void main(String[] args) {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();
    LottoService lottoService = new LottoService();

    int money = inputView.readMoney();
    List<Lotto> lottos = lottoService.buyLottos(money);

    resultView.printLottoCount(lottos.size());
    resultView.printLottos(lottos);

    List<Integer> winningNumbers = inputView.readWinningNumbers();
    Lotto winningLotto = Lotto.of(winningNumbers);

    LottoNumber bonusNumber = inputView.readBonusLottoNumber();
    validateBonusNumber(bonusNumber, winningLotto);

    LottoResult lottoResult = lottoService.calculateResult(lottos, winningLotto, bonusNumber);

    resultView.printLottoResult(lottoResult);
    resultView.printProfitRate(lottoResult.calculateProfitRate(money));
  }

  private static void validateBonusNumber(LottoNumber bonusNumber, Lotto winningLotto) {
    if (winningLotto.contains(bonusNumber)) {
      throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복되면 안 됩니다.");
    }
  }
}
