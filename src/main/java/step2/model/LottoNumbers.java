package step2.model;

import java.util.List;

public class LottoNumbers {

	private List<Integer> lottoNumbers;

	private LottoNumbers(List<Integer> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public static LottoNumbers randomNumbers() {
		RandomLottoFactory randomLottoFactory = new RandomLottoFactory();
		return new LottoNumbers(randomLottoFactory.randomLotto());
	}

	public static LottoNumbers handNumbers(List<Integer> handNumbers) {
		return new LottoNumbers(handNumbers);
	}

	public boolean contains(int bonusNumber) {
		return lottoNumbers.contains(bonusNumber);
	}

	public List<Integer> getLottoNumbers() {
		return lottoNumbers;
	}

}
