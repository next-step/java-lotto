package step4.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
	private static final int LOTTO_PRICE = 1000;
	private static final String LOTTO_PRICE_PHRASES = "로또 구입 금액은 1000원 단위만 가능합니다.";
	//private static final String MANUAL_LOTTO_COUNT = "입력하신 금액으로 구입할 수 있는 최대 로또 개수는 %s개 입니다.";

	private final int price;
	private final Lottos lottos;

	public LottoGame(int price, List<Lotto> manualLottos) {
		validPrice(price);
		this.price = price;
		this.lottos = new Lottos(manualLottos);
	}

	public Lottos getAllLottos() {
		int autoLottoCount = (price / LOTTO_PRICE) - this.lottos.size();
		List<Lotto> autoLottos = new ArrayList<>();
		for (int i = 0; i < autoLottoCount; i++) {
			autoLottos.add(Lotto.auto());
		}
		lottos.addLottos(new Lottos(autoLottos));
		return lottos;
	}

	private void validPrice(int price) {
		if (price == 0 || price % LOTTO_PRICE != 0) {
			throw new IllegalArgumentException(LOTTO_PRICE_PHRASES);
		}
	}
	/*
	private void validManualLottoCount(int price, int manualLottoCount) {
		if (manualLottoCount > (price / LOTTO_PRICE)) {
			throw new IllegalArgumentException(String.format(MANUAL_LOTTO_COUNT, (price / LOTTO_PRICE)));
		}
	}
	*/
}
