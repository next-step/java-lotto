package step3;

import step3.domain.Lotto;
import step3.domain.LottoIssuer;
import step3.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
	private final LottoIssuer issuer = new LottoIssuer();

	private static final int LOTTO_PRICE = 1000;

	public List<Lotto> startLottoGame() {
		int price = InputView.inputPrice();
		return this.getLottos(price);
	}

	public List<Lotto> getLottos(int price) {
		validPrice(price);
		int count = price / LOTTO_PRICE;

		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			lottos.add(new Lotto(issuer.issueAutoLotto()));
		}
		return lottos;
	}

	private void validPrice(int price) {
		if (price == 0 || price % LOTTO_PRICE != 0) {
			throw new IllegalArgumentException("로또 구입 금액은 1000원 단위만 가능합니다.");
		}
	}
}
