package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

	public static final int LOTTO_SIZE = 6;

	private final List<Integer> selectedNumbers;

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
}
