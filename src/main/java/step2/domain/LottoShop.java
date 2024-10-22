package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoShop {
	public static List<Lotto> buyLottos(Money money) {
		int amount = money.getMoney() / 1000;
		List<Lotto> lottos = new ArrayList<>();
		List<LottoNumber> numbers = LottoNumber.getLottoNumbers();
		for (int i = 0; i < amount; i++) {
			Collections.shuffle(numbers);
			Collections.sort(numbers);
			Lotto lotto = new Lotto(numbers.subList(0, 6));
			lottos.add(lotto);
		}
		return lottos;
	}
}
