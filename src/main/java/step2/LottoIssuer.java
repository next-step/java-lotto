package step2;

import java.util.ArrayList;
import java.util.List;

public class LottoIssuer {
	private static final int LOTTO_PRICE = 1000;
	private static final LottoNumber LOTTO_NUMBER = new LottoNumber();

	public static int getLottoCountByPrice(int price) {
		return price / LOTTO_PRICE;
	}

	public static List<Integer[]> issueAutoLottos(int count) {
		List<Integer[]> autoLottos = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			autoLottos.add(LOTTO_NUMBER.getAutoLotto());
		}
		return autoLottos;
	}

}
