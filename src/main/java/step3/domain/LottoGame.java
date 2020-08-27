package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
	private static final int LOTTO_PRICE = 1000;
	private static final String LOTTO_PRICE_PHRASES = "로또 구입 금액은 1000원 단위만 가능합니다.";

	public List<Lotto> getLottos(int price) {
		validPrice(price);
		int count = price / LOTTO_PRICE;

		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			lottos.add(new Lotto());
		}
		return lottos;
	}

	private void validPrice(int price) {
		if (price == 0 || price % LOTTO_PRICE != 0) {
			throw new IllegalArgumentException(LOTTO_PRICE_PHRASES);
		}
	}
}
