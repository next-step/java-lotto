package lotto;

import lotto.domain.Lottos;
import lotto.domain.Parser;
import lotto.domain.Winning;
import lotto.dto.WinningNumbersDTO;
import lotto.view.InputView;
import lotto.view.ResultView;

public class UserInterface {
    public static void main(String[] args) {
        int money = Parser.numberParsing(InputView.purchaseMoney());
        Lottos lottos = new Lottos(money);

        if(lottos.isEmpty()) {
            ResultView.noGame();
            return;
        }
        ResultView.purchaseCount(lottos);
        ResultView.lottos(lottos);
        String winningNumbers = InputView.winningNumbers();
        String bonusNumber = InputView.bonusNumber();
        WinningNumbersDTO winningNumbersDTO = new WinningNumbersDTO(winningNumbers, bonusNumber);
        System.out.println();
        ResultView.winningStaticsMessage();

        for (Winning winning : Winning.values()) {
            ResultView.winningStatics(winningNumbersDTO, lottos, winning);
        }
        ResultView.rateOfReturn(lottos.rateOfReturn(winningNumbersDTO));
    }
}
