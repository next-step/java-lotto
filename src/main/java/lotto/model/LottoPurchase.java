package lotto.model;

import java.util.ArrayList;
import java.util.List;

import lotto.service.GenerateLotto;

public class LottoPurchase {

	public static final int START_INCLUSIVE = 0;

	public static List<Lotto> buyLottos(int lottoCount) {
		List<Lotto> lottos = new ArrayList<>();
		for (int i = START_INCLUSIVE; i < lottoCount; i++) {
			List<Integer> lottoNumbers = GenerateLotto.generateLottoNumbers();
			lottos.add(new Lotto(lottoNumbers));
		}
		return lottos;
	}

}
