package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
	public static final int LOTTO_PRICE = 1000;
	private static final int LOTTO_SIZE = 6;
	private static final int START_LOTTO_NUMBER = 1;
	private static final int END_LOTTO_NUMBER = 45;

	private final List<Integer> lottoNumbers;

	public LottoNumbers(List<Integer> lottoNumbers) {
		System.out.println(lottoNumbers.size());
		checkValidSize(lottoNumbers);
		checkValidDuplication(lottoNumbers);
		checkValidNumbers(lottoNumbers);
		this.lottoNumbers = getSortedNumbers(lottoNumbers);
	}

	private List<Integer> getSortedNumbers(List<Integer> lottoNumbers) {
		List<Integer> sortedNumbers = new ArrayList<>(lottoNumbers);
		Collections.sort(sortedNumbers);
		return sortedNumbers;
	}

	public int getCountOfMatchLottoNumber(WinningLottoNumbers winningNumber) {
		return (int) winningNumber.getWinningLottoNumbers().getLottoNumbers().stream()
				.filter(this.lottoNumbers::contains)
				.count();
	}

	public List<Integer> getLottoNumbers() {
		return lottoNumbers;
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

	private void checkValidNumbers(List<Integer> winningLottoNumbers) {
		if (winningLottoNumbers.stream().noneMatch(this::isValidLottoNumber))
			throw new IllegalArgumentException("입력한 로또 번호가 1부터 45사이여야합니다.");
	}

	private boolean isValidLottoNumber(int lottoNumber) {
		return lottoNumber >= START_LOTTO_NUMBER && lottoNumber <= END_LOTTO_NUMBER;
	}

	@Override
	public String toString() {
		return lottoNumbers.toString();
	}

}
