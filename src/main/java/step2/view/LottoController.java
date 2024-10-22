package step2.view;

import java.util.List;

import step2.domain.Lotto;
import step2.domain.LottoStast;
import step2.domain.Money;
import step2.service.LottoGame;

public class LottoController {
	public static void main(String[] args) {
		Money money = InputView.getMoney();
		List<Lotto> lottos = LottoGame.playLotto(money);
		ResultView.printLottoResult(lottos);
		String winningNumbers = InputView.getWinningNumbers();
		LottoStast stastResult = LottoGame.getLottoStast(lottos, winningNumbers);
		ResultView.printLottoStast(stastResult);
	}
}
