package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoShop {
	public static List<Lotto> buyLottos(Money money) {
		int amount = money.getMoney() / 1000;
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < amount; i++) {
			lottos.add(new Lotto(shuffleSixNumbers()));
		}
		return lottos;
	}

	private static List<LottoNumber> shuffleSixNumbers() {
		List<LottoNumber> numberList = LottoNumber.getLottoNumbers();
		Collections.shuffle(numberList);
		List<LottoNumber> lottoNumbers = numberList.subList(0, 6);
		Collections.sort(lottoNumbers);
		return lottoNumbers;
	}
}
