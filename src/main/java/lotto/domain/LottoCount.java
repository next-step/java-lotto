package lotto.domain;

public class LottoCount {

	private static final int LOTTO_PRICE = 1000;

	private final int lottoCount;

	public LottoCount(int money) {
		lottoCount = money / LOTTO_PRICE;
	}

	public int getLottoCount() {
		return lottoCount;
	}
}
