package step4.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
	private int price;
	private final List<Lotto> lottos;

	private static final int LOTTO_PRICE = 1000;
	private static final String LOTTO_PRICE_PHRASES = "로또 구입 금액은 1000원 단위만 가능합니다.";
	private static final String MANUAL_LOTTO_COUNT = "입력하신 금액으로 구입할 수 있는 최대 로또 개수는 %s개 입니다.";

	public LottoGame() {
		this.price = 0;
		this.lottos = new ArrayList<>();
	}

	public void checkLottoPurchase(int price, int manualLottoCount) {
		validPrice(price);
		validManualLottoCount(price, manualLottoCount);
		this.price = price;
	}

	public List<Lotto> getLottos(List<Lotto> manualLottos) {
		lottos.addAll(manualLottos);
		int autoLottoCount = (price / LOTTO_PRICE) - manualLottos.size();
		setAutoLottoss(autoLottoCount);
		return lottos;
	}

	private void setAutoLottoss(int autoLottoCount) {
		for (int i = 0; i < autoLottoCount; i++) {
			lottos.add(new Lotto());
		}
	}

	////////////////
	public List<Lotto> getAutoLottos(int price) {
		int count = price / LOTTO_PRICE;

		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			lottos.add(new Lotto());
		}
		return lottos;
	}
	/////////////////

	private void validPrice(int price) {
		if (price == 0 || price % LOTTO_PRICE != 0) {
			throw new IllegalArgumentException(LOTTO_PRICE_PHRASES);
		}
	}

	private void validManualLottoCount(int price, int manualLottoCount) {
		if (manualLottoCount > (price / LOTTO_PRICE)) {
			throw new IllegalArgumentException(String.format(MANUAL_LOTTO_COUNT, (price / LOTTO_PRICE)));
		}
	}

}
