package step2_3.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoIssuer {
	private static final LottoNumber LOTTO_NUMBER = new LottoNumber();

	private LottoIssuer() {}

	public static int getLottoCountByPrice(int price) {
		return price / Lotto.getPrice();
	}

	public static List<Lotto> issueAutoLottos(int count) {
		List<Lotto> autoLottos = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			autoLottos.add(new Lotto(LOTTO_NUMBER.getRandomNumbers()));
		}
		return autoLottos;
	}

}
