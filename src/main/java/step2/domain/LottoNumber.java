package step2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class LottoNumber implements Comparable<LottoNumber> {
	private static final List<LottoNumber> CACHE_NUMBER = new ArrayList<>();
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;

	static {
		for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
			CACHE_NUMBER.add(new LottoNumber(i));
		}
	}

	private final int number;

	public LottoNumber(int number) {
		if (number < MIN_NUMBER || number > MAX_NUMBER) {
			throw new IllegalArgumentException("로또번호는 1~45의 숫자만 가능합니다.");
		}
		this.number = number;
	}

	public static List<LottoNumber> getLottoNumbers() {
		// 복사로 변조 방지
		return new ArrayList<>(CACHE_NUMBER);
	}

	public static List<LottoNumber> listFrom(String winningNumbers) {
		String[] splittedNumbers = winningNumbers.split(",");
		return Arrays.stream(splittedNumbers)
			.map((numberStr) -> new LottoNumber(Integer.parseInt(numberStr.trim())))
			.collect(Collectors.toList());
	}

	@Override
	public int compareTo(LottoNumber o) {
		return Integer.compare(this.number, o.number);
	}

	public int getNumber() {
		return number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumber that = (LottoNumber)o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(number);
	}
}
