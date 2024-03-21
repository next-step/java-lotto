package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoNumbers {
	private static final int LOTTO_SIZE = 6;
	private List<Integer> winningLottoNumbers;

	public WinningLottoNumbers(List<Integer> winningLottoNumbers) {
		checkValidSize(winningLottoNumbers);
		checkValidDuplication(winningLottoNumbers);
		this.winningLottoNumbers = winningLottoNumbers;
	}

	private void checkValidDuplication(List<Integer> winningLottoNumbers) {
		int distinctList = winningLottoNumbers.stream().distinct().collect(Collectors.toList()).size();
		if (winningLottoNumbers.size() != distinctList) {
			throw new IllegalArgumentException("입력한 로또 숫자에 중복된 값이 있습니다.");
		}
	}

	private void checkValidSize(List<Integer> winningLottoNumbers) {
		if (winningLottoNumbers.size() != LOTTO_SIZE)
			throw new IllegalArgumentException("입력한 로또 사이즈가 6이여야 합니다!");
	}

	public List<Integer> getWinningLottoNumbers() {
		return winningLottoNumbers;
	}

}
