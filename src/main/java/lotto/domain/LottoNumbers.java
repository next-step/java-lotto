package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

	public static final List<Integer> NUMBERS = Arrays.asList(
		1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
		16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
		31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45
	);

	private final List<Integer> lottoNumbers;

	public LottoNumbers() {
		Collections.shuffle(LottoNumbers.NUMBERS);
		this.lottoNumbers = new ArrayList<>(LottoNumbers.NUMBERS.subList(0, Lotto.SIZE));;
	}

	public LottoNumbers(List<Integer> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public boolean contains(int lottoNumber) {
		return this.lottoNumbers.contains(lottoNumber);
	}

	@Override
	public String toString() {
		return this.lottoNumbers.toString();
	}
}
