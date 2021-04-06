package im.juniq.lotto.domain;

public class LottoNumber {
	private static final int FIRST_LOTTO_NUMBER = 1;
	private static final int LAST_LOTTO_NUMBER = 45;
	private final int number;

	public LottoNumber(int number) {
		if (number < FIRST_LOTTO_NUMBER || number > LAST_LOTTO_NUMBER) {
			throw new IllegalArgumentException("로또 번호는 " + FIRST_LOTTO_NUMBER + " ~ " + LAST_LOTTO_NUMBER + " 범위 안이어야 합니다.");
		}
		this.number = number;
	}
}
