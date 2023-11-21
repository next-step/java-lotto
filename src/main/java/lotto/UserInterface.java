package lotto;

import lotto.domain.*;
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

        Lotto winningNumber = new Lotto(InputView.winningNumbers());

        BonusNumber bonusNumber = new BonusNumber(InputView.bonusNumber());

        if (winningNumber.contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException("당첨 번호에 보너스 볼 번호가 포함되면 안됩니다.");
        }
        WinningNumbersDTO winningNumbersDTO = new WinningNumbersDTO(winningNumber, bonusNumber);
        System.out.println();
        ResultView.winningStaticsMessage();

        for (Winning winning : Winning.values()) {
            ResultView.winningStatics(winningNumbersDTO, lottos, winning);
        }
        ResultView.rateOfReturn(lottos.rateOfReturn(winningNumbersDTO));
    }
}
