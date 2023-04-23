package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class SelectedNumbers {

	private final List<Integer> selectedNumbers;

	public SelectedNumbers() {
		this.selectedNumbers = new ArrayList<>();
	}

	public boolean contains(int lottoNumber) {
		return this.selectedNumbers.contains(lottoNumber);
	}

	public void add(int lottoNumber) {
		this.selectedNumbers.add(lottoNumber);
	}

	public int size() {
		return this.selectedNumbers.size();
	}
}
