package step4.domain;

public class LottoGame {
	private static final int LOTTO_PRICE = 1000;
	private static final String LOTTO_PRICE_PHRASES = "로또 구입 금액은 1000원 단위만 가능합니다.";
	private static final String MANUAL_LOTTO_COUNT = "입력하신 금액으로 구입할 수 있는 최대 로또 개수는 %s개 입니다.";

	private final int price;

	public LottoGame(int price, int manualCount) {
		validManualLottoCount(price, manualCount);
		this.price = price;
	}
	
	public Lottos buyLotto(String[] inputLottos) {
		Lottos manuals = Lottos.createManualLottos(inputLottos);
		int autoLottoCount = (price / LOTTO_PRICE) - manuals.size();
		Lottos autos = Lottos.createAutoLottos(autoLottoCount);

		return manuals.addLottos(autos);
	}

	private void validManualLottoCount(int price, int manualLottoCount) {
		if (price == 0 || price % LOTTO_PRICE != 0) {
			throw new IllegalArgumentException(LOTTO_PRICE_PHRASES);
		}
		if (manualLottoCount > (price / LOTTO_PRICE)) {
			throw new IllegalArgumentException(String.format(MANUAL_LOTTO_COUNT, (price / LOTTO_PRICE)));
		}
	}

}
