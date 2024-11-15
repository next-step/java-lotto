package step2.view;

import step2.domain.LottoStatistics;
import step2.dto.LottoPlayResultDto;
import step2.dto.PlayLottoDto;
import step2.service.LottoGame;

public class LottoController {
	public static void main(String[] args) {
		try {
			PlayLottoDto playLottoDto = InputView.getPlayLottoParams();
			LottoPlayResultDto resultDto = LottoGame.playLotto(playLottoDto);
			ResultView.printLottoResult(resultDto);

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
