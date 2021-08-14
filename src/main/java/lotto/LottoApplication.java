package lotto;

import lotto.common.AutoNumberGenerator;
import lotto.common.ManualNumberGenerator;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import static lotto.util.StringUtil.split;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        LottoMachine lottoMachine = new LottoMachine();

        Money money = new Money(inputView.askPurchaseAmount());

        Lottos lottos = lottoMachine.generateLottos(money, new AutoNumberGenerator());

        ResultView resultView = new ResultView();
        resultView.printLotties(lottos);

        //FIXME : 입력값이 잘못된게 들어오면..?
        //앞에서 예외처리? generator에서? lottoNumbers에서? lottonumber? 별도의 예외 유틸 클래스 만들기?
        LottoNumbers winningNumbers = new LottoNumbers(new ManualNumberGenerator(split(inputView.getWinningNumber())));
        
        LottoNumber bonusNumber = new LottoNumber(inputView.askBonusNumber());
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        WinningStatistics winningStatistics = new WinningStatistics(lottos, winningLotto);

        resultView.printSameNumbers(winningStatistics);
    }
}
