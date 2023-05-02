package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {

	public static final List<Integer> NUMBERS = Arrays.asList(
		1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
		16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
		31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45
	);

	private final List<LottoNumber> lottoNumbers;

	public LottoNumbers() {
		Collections.shuffle(LottoNumbers.NUMBERS);
		List<Integer> autoLottoNumbers = LottoNumbers.NUMBERS.subList(0, Lotto.SIZE);
		this.lottoNumbers = new ArrayList<>();
		for (int lottoNumber : autoLottoNumbers) {
			this.lottoNumbers.add(LottoNumber.of(lottoNumber));
		}
	}

	public LottoNumbers(List<LottoNumber> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public static Set<LottoNumber> create(String input) {
		Set<LottoNumber> lottoNumbers = new LinkedHashSet<>();
		for (String numberString : input.split(", ")) {
			lottoNumbers.add(LottoNumber.of(numberString));
		}
		return lottoNumbers;
	}

	// TC 작성을 수월하게 하기 위한 생성자, 프로덕션 코드에서 사용금지.
	public LottoNumbers(int... lottoNumbers) {
		this.lottoNumbers = Arrays.stream(lottoNumbers)
			.mapToObj(LottoNumber::of).collect(Collectors.toList());
	}

	public boolean contains(LottoNumber lottoNumber) {
		return this.lottoNumbers.contains(lottoNumber);
	}

	@Override
	public String toString() {
		return this.lottoNumbers.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumbers that = (LottoNumbers)o;
		return Objects.equals(lottoNumbers, that.lottoNumbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumbers);
	}

	public int matchCount(LottoNumbers winNumbers) {
		int matchCount = 0;
		for (LottoNumber lottoNumber : this.lottoNumbers) {
			if (winNumbers.contains(lottoNumber)) {
				matchCount++;
			}
		}
		return matchCount;
	}
}
