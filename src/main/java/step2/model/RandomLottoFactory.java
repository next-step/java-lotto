package step2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoFactory implements LottoFactory {

	private static final int FIRST_NUM = 1;
	private static final int MAX_NUM = 45;
	private static final int LAST_NUM = 6;
	private static final List<Integer> LOTTO_NUMBERS_POOL = new ArrayList<>();

	static {
		for (int i = FIRST_NUM; i <= MAX_NUM; i++) {
			LOTTO_NUMBERS_POOL.add(i);
		}
	}

	@Override
	public List<Integer> getLottoNum() {
		List<Integer> lottoSet = new ArrayList<>();
		Collections.shuffle(LOTTO_NUMBERS_POOL);

		for (int i = FIRST_NUM; i <= LAST_NUM; i++) {
			lottoSet.add(LOTTO_NUMBERS_POOL.get(i));
		}

		Collections.sort(lottoSet);
		return lottoSet;
	}
}
