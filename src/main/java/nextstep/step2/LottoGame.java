package nextstep.step2;

import nextstep.step2.domain.LottoNumber;
import nextstep.step2.domain.Lotto;
import nextstep.step2.domain.LottoPurchase;
import nextstep.step2.view.InputView;
import nextstep.step2.view.LottoResultView;

import java.util.List;
import java.util.Scanner;

public class LottoGame {
	public static void main(String[] args) {
		LottoController controller = new LottoController();
		InputView inputMoney = new InputView(new Scanner(System.in));
		LottoResultView resultView = new LottoResultView();

		LottoPurchase purchase = new LottoPurchase(inputMoney.getInputMessage());
		List<Lotto> autoLottos = controller.startLottoGameGetLottos(purchase, resultView);

		InputView inputWinningNumbers = new InputView(new Scanner(System.in));
		final String winningNumber = inputWinningNumbers.getInputLottoWinningNumbers();

		InputView inputBonusNumber = new InputView(new Scanner(System.in));
		final LottoNumber bonusNumber = new LottoNumber(inputBonusNumber.getInputLottoBonusNumber());
		controller.printLottoStaticsic(winningNumber, bonusNumber, purchase, autoLottos, resultView);
	}
}
