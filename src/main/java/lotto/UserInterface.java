package lotto;

import lotto.domain.*;
import lotto.dto.WinningLottoDTO;
import lotto.view.InputView;
import lotto.view.ResultView;

public class UserInterface {
    public static void main(String[] args) {
        Amount money = Amount.of(new PositiveNumber(InputView.purchaseMoney()));
        PositiveNumber manualCount = new PositiveNumber(Parser.parseNumberFormat(InputView.manualCount()));
        Amount manualPurchaseMoney = Amount.of((manualCount.getPositiveNumber() * Lotto.LOTTO_PRICE));

        if (money.compareTo(manualPurchaseMoney) < 0) {
            throw new IllegalArgumentException("금액을 초과하여 구매할수 없습니다.");
        }

        Lottos lottos = new Lottos(money.minus(manualPurchaseMoney), InputView.manualLottos(manualCount));

        if (lottos.isEmpty()) {
            ResultView.noGame();
            return;
        }

        ResultView.purchaseCount(lottos, manualCount);
        ResultView.lottos(lottos);
        Lotto winningNumber = new Lotto(InputView.winningNumbers());
        LottoNumber bonusNumber = LottoNumber.of(InputView.bonusNumber());

        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호에 보너스 볼 번호가 포함되면 안됩니다.");
        }

        WinningLottoDTO winningLottoDTO = new WinningLottoDTO(winningNumber, bonusNumber);
        System.out.println();
        ResultView.winningStaticsMessage();

        for (Winning winning : Winning.values()) {
            ResultView.winningStatics(winningLottoDTO, lottos, winning);
        }

        ResultView.rateOfReturn(lottos.rateOfReturn(winningLottoDTO));
    }
}
