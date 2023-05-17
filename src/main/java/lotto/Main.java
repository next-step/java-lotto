package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int money = InputView.inputPay();
        Customer customer = new Customer(money);
        int manualCount = InputView.inputCount();
        List<Set<Integer>> manualNumbers = new ArrayList<>();
        if (manualCount > 0) {
            manualNumbers = InputView.inputManualNumbers(manualCount);
        }

        customer.buyLotto(manualCount, manualNumbers);

        OutputView.showLottos(customer.getManualLotto(), customer.getAutoLotto());
        Set<Integer> lastNumbers = InputView.lastWinNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        WinNumber winNumber = new WinNumber(lastNumbers, bonusNumber);

        Map<KLottoRank, Integer> lottoResult = customer.checkLottoWin(winNumber);
        OutputView.LottoResult(lottoResult, customer);
    }
}
