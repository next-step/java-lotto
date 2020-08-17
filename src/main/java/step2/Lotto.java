package step2;

public class Lotto {
	private static final int LOTTO_PRICE = 1000;

	public static int getLottoCountByPrice(int price) {
		return price / LOTTO_PRICE;
	}
}
