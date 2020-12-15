package lotto.domain;

public class LottoLottery {
	private static final int LOTTO_PRICE_PER_PIECE = 1000;
	private static final Price price = new Price(LOTTO_PRICE_PER_PIECE);

	public static Price getPrice() {
		return price;
	}
}
