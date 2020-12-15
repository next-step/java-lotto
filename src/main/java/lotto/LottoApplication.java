package lotto;

import lotto.domain.LottoTickets;
import lotto.domain.WinningLottoNumbers;
import lotto.view.InputView;

/**
 * @author : byungkyu
 * @date : 2020/12/14
 * @description :
 **/
public class LottoApplication {
	public static void main(String[] args) {
		LottoTickets lottoTickets = InputView.requireCash();
		WinningLottoNumbers winningLottoNumbers = InputView.requireWinningNumber();
		InputView.printWinningStatistics(lottoTickets, winningLottoNumbers);
	}
}
