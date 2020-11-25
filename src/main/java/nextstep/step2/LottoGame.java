package nextstep.step2;

import nextstep.step2.domain.*;
import nextstep.step2.view.InputView;
import nextstep.step2.view.LottoResultView;

import java.util.List;
import java.util.Scanner;

public class LottoGame {
	public static void main(String[] args) {
		LottoController controller = new LottoController();
		LottoResultView resultView = new LottoResultView();
		int money = getMoney(); //구입금액 입력
		int manualCount = getManualCount(); //수동 구매수 입력
		LottoPurchase purchase = new LottoPurchase(money);
		String manaulLottos = getManualLottos(manualCount); //수동 로또번호 입력
		//수동, 자동 로또번호 출력
		List<Lotto> autoLottos = getPurchaseLottos(controller, resultView, manualCount, purchase, manaulLottos);
		final String winningNumber = getLastWeekLotto(); //지난주 로또번호 입력
		final LottoNumber bonusNumber = getBonusNumber();  //보너스 번호 입력
		//당첨통계 출력
		LottoStaticstic lottoStaticstic = new LottoStaticstic(winningNumber, purchase, bonusNumber);
		controller.printLottoStaticsic(lottoStaticstic, autoLottos, resultView);
	}

	private static LottoNumber getBonusNumber() {
		InputView inputBonusNumber = new InputView(new Scanner(System.in));
		return LottoNumber.of(inputBonusNumber.getInputLottoBonusNumber());
	}

	private static String getLastWeekLotto() {
		InputView inputWinningNumbers = new InputView(new Scanner(System.in));
		return inputWinningNumbers.getInputLottoWinningNumbers();
	}

	private static List<Lotto> getPurchaseLottos(LottoController controller, LottoResultView resultView, int manualCount, LottoPurchase purchase, String manaulLottos) {
		LottoCount lottoCount = new LottoCount(manualCount, purchase.getLottoCount());
		return controller.startLottoGameGetLottos(lottoCount, manaulLottos, resultView);
	}

	private static String getManualLottos(int manualCount) {
		InputView inputManualNumbers = new InputView(new Scanner(System.in));
		return inputManualNumbers.getInputManualNumbers(manualCount);
	}

	private static int getManualCount() {
		InputView inputManualCount = new InputView(new Scanner(System.in));
		return inputManualCount.getInputManualCount();
	}

	private static int getMoney() {
		InputView inputMoney = new InputView(new Scanner(System.in));
		return inputMoney.getInputMoney();
	}
}
