package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRules;
import lotto.domain.User;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    
    private User user;
    
    public void play() {
        settingLottos();
        settingWinningNumber();
        showResult();
    }
    
    private void settingLottos() {
        int totalLottoCount = InputView.inputPrice() / LottoRules.LOTTO_PRICE;
        int manualCount = InputView.inputManualLottoCount(totalLottoCount);
        List<Lotto> manualLottos = InputView.inputManualLottos(manualCount);
        OutputView.outputLottoCount(totalLottoCount, manualCount);
        user = new User(totalLottoCount, manualLottos);
        OutputView.printLottos(user.getLottos());
    }
    
    private void settingWinningNumber() {
        List<Integer> numbers = InputView.getWinningNumber();
        int bonusBall = InputView.getBonusBall();
        WinningNumber winningNumber = new WinningNumber(numbers, bonusBall);
        user.setRanks(winningNumber);
    }
    
    private void showResult() {
        double reward = OutputView.printResult(user.getRanks());
        OutputView.printYield(LottoRules.calculateYield(reward, user.getLottoCount()));
    }
}
