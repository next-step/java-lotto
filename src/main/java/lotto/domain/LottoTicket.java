package lotto.domain;

import com.google.common.base.Preconditions;

import java.util.List;

/**
 * Created by hspark on 06/11/2018.
 */
public class LottoTicket {
	private List<Integer> lottoNumbers;

	public LottoTicket(LottoMachine lottoMachine) {
		this.lottoNumbers = lottoMachine.drawLottNumbers();
	}

	public LottoWinnerType matchNumber(List<Integer> winningNumberList) {
		Preconditions.checkArgument(winningNumberList.size() == 6, "로또 숫자는 6자리여야 합니다.");

		int matchingCount = 0;
		for (Integer winningNumber : winningNumberList) {
			matchingCount += lottoNumbers.contains(winningNumber) ? 1 : 0;
		}

		return LottoWinnerType.findByMatchingCount(matchingCount);
	}
}
