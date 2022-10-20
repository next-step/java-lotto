package step3;

public class LottoAmount {

	private int amount;

	public LottoAmount(int input) {
		if (input < 1000) {
			throw new IllegalArgumentException("최소 금액은 1000원 입니다");
		}
		amount = (input) / 1000;
	}

	public int amountOfLottos() {
		return amount;
	}
}
