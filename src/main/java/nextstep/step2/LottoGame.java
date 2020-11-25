package nextstep.step2;

import nextstep.step2.domain.*;
import nextstep.step2.view.InputView;

public class LottoGame {
	public static void main(String[] args) {
		LottoController controller = new LottoController();

		//수동, 자동 로또번호 출력
		final int money = InputView.getInputMoney(); //구입금액 입력
		final int manualCount = InputView.getInputManualCount(); //수동 구매수 입력
		String manaulLottos = InputView.getInputManualNumbers(manualCount); //수동 로또번호 입력
		LottoPurchase purchase = new LottoPurchase(money);
		Lottos autoLottos = getPurchaseLottos(controller, manualCount, purchase, manaulLottos);

		//당첨통계 출력
		final String winningNumber = InputView.getInputLottoWinningNumbers(); //지난주 로또번호 입력
		final LottoNumber bonusNumber = LottoNumber.of(InputView.getInputLottoBonusNumber());  //보너스 번호 입력
		LottoStaticstic lottoStaticstic = new LottoStaticstic(winningNumber, purchase, bonusNumber);
		controller.printLottoStaticsic(lottoStaticstic, autoLottos);
	}

	private static Lottos getPurchaseLottos(LottoController controller, int manualCount, LottoPurchase purchase, String manaulLottos) {
		LottoCount lottoCount = new LottoCount(manualCount, purchase.getLottoCount());
		return controller.startLottoGameGetLottos(lottoCount, manaulLottos);
	}
}
