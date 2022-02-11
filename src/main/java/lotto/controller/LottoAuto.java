package lotto.controller;

import java.util.List;
import lotto.domain.LottoRules;
import lotto.domain.User;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoAuto {
    
    public void play() {
        int lottoCount = InputView.getPrice() / LottoRules.LOTTO_PRICE;
        User user = new User(OutputView.getLottoCount(lottoCount));
        OutputView.printLottos(user.getLottos());
        List<Integer> numbers = InputView.getWinningNumber();
        int bonusBall = InputView.getBonusBall();
        WinningNumber winningNumber = new WinningNumber(numbers, bonusBall);
        user.setRanks(winningNumber);
        double reward = OutputView.printResult(user.getRanks());
        OutputView.printYield(LottoRules.calculateYield(reward, user.getCount()));
    }
}
