package domain.lotto;

public class LottoNumber {

	private final int number;

	public LottoNumber(int number) {
		if (number < 1 || number > 45) {
			throw new IllegalArgumentException("로또 숫자는 1부터 45이하여야 합니다.");
		}
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}
