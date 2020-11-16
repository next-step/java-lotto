package nextstep.step2;

import nextstep.step2.domain.Lotto;
import nextstep.step2.domain.LottoPurchase;
import nextstep.step2.view.InputView;

import java.util.List;
import java.util.Scanner;

public class LottoGame {
	public static void main(String[] args) {
		LottoController controller = new LottoController();
		InputView inputMoney = new InputView(new Scanner(System.in));
		LottoPurchase purchase = new LottoPurchase(inputMoney.getInputMessage());
		List<Lotto> autoLottos = controller.startLottoGameGetLottos(purchase);

		InputView inputWinningNumbers = new InputView(new Scanner(System.in));
		controller.printLottoStaticsic(inputWinningNumbers.getInputLottoWinningNumbers(), purchase, autoLottos);
	}
}
