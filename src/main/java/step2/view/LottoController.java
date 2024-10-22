package step2.view;

import step2.domain.LottoResult;
import step2.domain.LottoStast;
import step2.domain.Money;
import step2.service.LottoGame;

public class LottoController {
	public static void main(String[] args) {
		Money money = InputView.getMoney();
		LottoResult result = LottoGame.playLotto(money);
		ResultView.printLottoResult(result);
		String winningNumbers = InputView.getWinningNumbers();
		LottoStast stastResult = LottoGame.getLottoStast(result, winningNumbers);
		ResultView.printLottoStast(stastResult);
	}
}
