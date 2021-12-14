package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningResult {
	private final WinningNumbers winningNumbers;
	private final List<LottoNumbers> purchasedLottos;

	public WinningResult(WinningNumbers winningNumbers, List<LottoNumbers> purchasedLottos) {
		this.winningNumbers = winningNumbers;
		this.purchasedLottos = purchasedLottos;
	}

	public List<LotteryWinnings> calculatedLotteryWinnings() {
		List<LotteryWinnings> lotteryWinningsList = new ArrayList<>();
		for (LottoNumbers purchasedLotto : this.purchasedLottos) {
			List<LottoNumber> lottoNumbers = purchasedLotto.lottoNumbers();
			List<Boolean> matches = matchedLottoNumber(lottoNumbers);
			LotteryWinnings winnings = findPlace(matches.size());
			lotteryWinningsList.add(winnings);
		}
		return lotteryWinningsList;
	}

	private List<Boolean> matchedLottoNumber(List<LottoNumber> lottoNumbers) {
		List<Boolean> matches = new ArrayList<>();
		for (LottoNumber winningNumber : winningNumbers.getWinningNumbers()) {
			boolean matched = lottoNumbers.contains(winningNumber);
			if (matched)
				matches.add(true);
		}
		return matches;
	}

	private LotteryWinnings findPlace(int size) {
		if (size == 3) {
			return fifthPlace();
		}

		if (size == 4) {
			return fourthPlace();
		}

		if (size == 5) {
			return thirdPlace();
		}

		if (size == 6) {
			return firstPlace();
		}
		return new LotteryWinnings(0);
	}

	public LotteryWinnings fifthPlace() {
		return new LotteryWinnings(5);
	}

	public LotteryWinnings fourthPlace() {
		return new LotteryWinnings(4);
	}

	public LotteryWinnings thirdPlace() {
		return new LotteryWinnings(3);
	}

	public LotteryWinnings firstPlace() {
		return new LotteryWinnings(1);
	}
}
