package lotto;

import java.util.*;

public class LottoNumbers {
	private final List<Integer> lottoNumbers;

	public LottoNumbers(List<Integer> lottoNumbers) {
		this.lottoNumbers = getSortedNumbers(lottoNumbers);
	}

	//todo: 해당 값은 LottoShuffle에서 할당되는데, 45에 대한 예외처리 해야하나?

	private List<Integer> getSortedNumbers(List<Integer> lottoNumbers) {
		List<Integer> sortedNumbers = new ArrayList<>(lottoNumbers);
		Collections.sort(sortedNumbers);
		return sortedNumbers;
	}

	public int getCountOfMatchLottoNumber(List<Integer> winningNumber) {
		return (int) winningNumber.stream()
				.filter(this.lottoNumbers::contains)
				.count();
	}

	public List<Integer> getLottoNumbers() {
		return lottoNumbers;
	}

}
