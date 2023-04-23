package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

	public static final int LOTTO_SIZE = 6;

	private final List<Integer> selectedNumbers;
	private int winCount;

	public Lotto() {
		this.selectedNumbers = new ArrayList<>();
	}

	public void selectLottoNumbers(int lottoNumber) {
		if (this.selectedNumbers.contains(lottoNumber) == false) {
			this.selectedNumbers.add(lottoNumber);
		}
	}

	public int selectedNumbersSize() {
		return this.selectedNumbers.size();
	}

	public int winCount(List<Integer> winNumbers) {
		for (Integer winNumber : winNumbers) {
			this.plusWinCount(winNumber);
		}
		return this.winCount;
	}

	private void plusWinCount(Integer winNumber) {
		if (selectedNumbers.contains(winNumber)) {
			winCount++;
		}
	}
}
