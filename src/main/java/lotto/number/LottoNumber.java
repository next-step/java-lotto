package lotto.number;

public class LottoNumber {

	private static final int LOTTO_NUMBER_RANGE_INCLUSIVE_MIN = 1;
	private static final int LOTTO_NUMBER_RANGE_INCLUSIVE_MAX = 45;
	private static final String VALIDATE_MSG_RANGE_WRONG = "each lottoNumber range must in 1~45";

	private final int number;

	public LottoNumber(int number) {
		this.number = number;
		validate(number);
	}

	private static void validate(int number) {
		if (number < LOTTO_NUMBER_RANGE_INCLUSIVE_MIN || number > LOTTO_NUMBER_RANGE_INCLUSIVE_MAX) {
			throw new IllegalArgumentException(VALIDATE_MSG_RANGE_WRONG);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof LottoNumber) {
			return ((LottoNumber) obj).number == this.number;
		}
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return number;
	}

	@Override
	public String toString() {
		return String.format("%d", number);
	}
}
