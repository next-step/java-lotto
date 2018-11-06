package lotto.domain;

import java.util.List;

/**
 * Created by hspark on 06/11/2018.
 */
public class LottoTicket {
	private List<Integer> lottoNumbers;

	public LottoTicket(LottoMachine lottoMachine) {
		this.lottoNumbers = lottoMachine.drawLottNumbers();
	}

	public LottoWinnerType matchNumber(List<Integer> winningNubmer){
		return null;
	}
}
