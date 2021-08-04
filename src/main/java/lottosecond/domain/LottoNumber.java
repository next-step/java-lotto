package lottosecond.domain;

public class LottoNumber implements Comparable<LottoNumber> {

	private final int number;

	private LottoNumber(int number) {
		this.number = number;
	}

	public static LottoNumber valueOf(int number) {
		if (invalidRange(number)) {
			throw new LottoNumberException();
		}
		return LottoNumberCache.caches[number];
	}

	private static boolean invalidRange(int number) {
		return number < LottoNumberCache.MIN_NUMBER || number > LottoNumberCache.MAX_NUMBER;
	}

		public int getNumber() {
		return number;
	}

	@Override
	public int compareTo(LottoNumber o) {
		return number > o.getNumber() ? 1 : -1;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		LottoNumber number1 = (LottoNumber) o;

		return getNumber() == number1.getNumber();
	}

	@Override
	public int hashCode() {
		return getNumber();
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}

	/**
	 * @see Integer.IntegerCache
	 */
	private static class LottoNumberCache {

		static final int MIN_NUMBER = 1;
		static final int MAX_NUMBER = 45;
		static final LottoNumber[] caches;

		static {
			caches = new LottoNumber[MAX_NUMBER + 1];

			for (int i = MIN_NUMBER; i <= MAX_NUMBER ; i++) {
				caches[i] = new LottoNumber(i);
			}
		}

		private LottoNumberCache() {}

	}

}
