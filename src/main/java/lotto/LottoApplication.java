package lotto;

import lotto.common.AutoNumberGenerator;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.util.StringUtil.split;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        LottoMachine lottoMachine = new LottoMachine();

        Money money = new Money(inputView.askPurchaseAmount());

        Lottos lottos = lottoMachine.generateLottos(money, new AutoNumberGenerator());

        ResultView resultView = new ResultView();
        resultView.printLotties(lottos);

        String[] split = split(inputView.getWinningNumber());
        List<Integer> winningNumbers = Stream.of(split).map(Integer::valueOf).collect(Collectors.toList());

        Lotto winningLottoNumbers = Lotto.getInstanceByInteger(winningNumbers);

        LottoNumber bonusNumber = new LottoNumber(Integer.parseInt(inputView.askBonusNumber()));

        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

        WinningStatistics winningStatistics = new WinningStatistics(lottos, winningLotto);

        resultView.printSameNumbers(winningStatistics);
    }
}
