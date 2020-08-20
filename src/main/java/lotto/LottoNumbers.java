package lotto;

import java.util.Collections;
import java.util.List;

public class LottoNumbers {
	private static final int LOTTO_NUMBERS_PER_GAME = 6;

	private final List<Integer> lottoNumbers;

	private LottoNumbers(List<Integer> lottoNumbers) {
		Collections.sort(lottoNumbers);
		this.lottoNumbers = lottoNumbers;
	}

	public static LottoNumbers of(List<Integer> lottoNumbers) {
		if (lottoNumbers == null || lottoNumbers.isEmpty()) {
			throw new IllegalArgumentException("당첨번호가 비어있습니다.");
		}
		if (lottoNumbers.size() != LOTTO_NUMBERS_PER_GAME) {
			throw new IllegalArgumentException("당첨번호는 6개를 입력해주세요.");
		}
		return new LottoNumbers(lottoNumbers);
	}

	public int getSameCountWith(LottoNumbers otherBalls) {
		return otherBalls.lottoNumbers.stream()
									  .mapToInt(lottoNumber -> this.lottoNumbers.contains(lottoNumber) ? 1 : 0)
									  .sum();
	}

	@Override
	public String toString() {
		return lottoNumbers.toString();
	}
}
