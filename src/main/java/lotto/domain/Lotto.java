package lotto.domain;

import java.util.List;

public class Lotto {

	public static final int SIZE = 6;
	public static final int PRICE = 1000;
	public static final int MINIMUM_BOUND = 1;
	public static final int MAXIMUM_BOUND = 45;

	private final SelectedNumbers selectedNumbers;
	private final Score score;

	public Lotto() {
		this.selectedNumbers = new SelectedNumbers();
		this.score = new Score(0);
	}

	public Lotto(int score) {
		this.selectedNumbers = new SelectedNumbers();
		this.score = new Score(score);
	}

	public void selectLottoNumbers(int lottoNumber) {
		if (this.selectedNumbers.contains(lottoNumber) == false) {
			this.selectedNumbers.add(lottoNumber);
		}
	}

	public int selectedNumbersSize() {
		return this.selectedNumbers.size();
	}

	public Score calculateScore(List<Integer> winNumbers) {
		for (Integer winNumber : winNumbers) {
			this.plusScore(winNumber);
		}
		return this.score;
	}

	public Score getScore() {
		return this.score;
	}

	private void plusScore(Integer winNumber) {
		if (selectedNumbers.contains(winNumber)) {
			this.score.plus();
		}
	}

	public SelectedNumbers getSelectedNumbers() {
		return selectedNumbers;
	}
}
