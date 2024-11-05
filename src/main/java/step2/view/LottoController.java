package step2.view;

import step2.domain.LottoStatistics;
import step2.domain.Money;
import step2.dto.LottoPlayResultDto;
import step2.service.LottoGame;

public class LottoController {
	public static void main(String[] args) {
		try {
			Money money = InputView.getMoney();
			LottoPlayResultDto resultDto = LottoGame.playLotto(money);
			ResultView.printLottoResult(resultDto.getLottos());

			String winningSixNumbers = InputView.getWinningNumbers();
			String bonusNumber = InputView.getBonusNumber();

			LottoStatistics stastResult = LottoGame.getLottoStast(resultDto.getLottos(), winningSixNumbers,
				bonusNumber);
			ResultView.printLottoStast(stastResult);
			ResultView.printChange(resultDto.getChange());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
