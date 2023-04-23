package lotto.domain;

import java.util.List;

public class Lotto {

	public static final int LOTTO_SIZE = 6;
	public static final int LOTTO_PRICE = 1000;

	private final SelectedNumbers selectedNumbers;
	private final WinCount winCount;

	public Lotto() {
		this.selectedNumbers = new SelectedNumbers();
		this.winCount = new WinCount(0);
	}

	public Lotto(int winCount) {
		this.selectedNumbers = new SelectedNumbers();
		this.winCount = new WinCount(winCount);
	}

	public void selectLottoNumbers(int lottoNumber) {
		if (this.selectedNumbers.contains(lottoNumber) == false) {
			this.selectedNumbers.add(lottoNumber);
		}
	}

	public int selectedNumbersSize() {
		return this.selectedNumbers.size();
	}

	public WinCount winCount(List<Integer> winNumbers) {
		for (Integer winNumber : winNumbers) {
			this.plusWinCount(winNumber);
		}
		return this.winCount;
	}

	public WinCount getWinCount() {
		return this.winCount;
	}

	private void plusWinCount(Integer winNumber) {
		if (selectedNumbers.contains(winNumber)) {
			this.winCount.plus();
		}
	}
}
