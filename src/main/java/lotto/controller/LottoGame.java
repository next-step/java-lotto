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
    
    private void showResult() {
        double reward = OutputView.printResult(user.getRanks());
        OutputView.printYield(LottoRules.calculateYield(reward, user.getCount()));
    }
    
    private void settingWinningNumber() {
        List<Integer> numbers = InputView.getWinningNumber();
        int bonusBall = InputView.getBonusBall();
        WinningNumber winningNumber = new WinningNumber(numbers, bonusBall);
        user.setRanks(winningNumber);
    }
    
    private void settingLottos() {
        int lottoCount = InputView.getPrice() / LottoRules.LOTTO_PRICE;
        int manualCount = InputView.inputManualLottoCount(lottoCount);
        List<Lotto> manualLottos = InputView.inputManualLottos(manualCount);
        OutputView.outputLottoCount(lottoCount, manualCount);
        user = new User(lottoCount, manualLottos);
        OutputView.printLottos(user.getLottos());
    }
}
