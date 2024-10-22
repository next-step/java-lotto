package step2.view;

import step2.domain.LottoStast;
import step2.domain.Money;
import step2.dto.LottoPlayResultDto;
import step2.service.LottoGame;

public class LottoController {
	public static void main(String[] args) {
		Money money = InputView.getMoney();
		LottoPlayResultDto resultDto = LottoGame.playLotto(money);
		ResultView.printLottoResult(resultDto.getLottos());
		String winningNumbers = InputView.getWinningNumbers();
		LottoStast stastResult = LottoGame.getLottoStast(resultDto.getLottos(), winningNumbers);
		ResultView.printLottoStast(stastResult);
		ResultView.printChange(resultDto.getChange());
	}
}
