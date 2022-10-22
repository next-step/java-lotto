package step2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoFactory implements LottoFactory {

	private static final int FIRST_NUM = 1;
	private static final int MAX_NUM = 45;
	private static final int LAST_NUM = 6;
	private static final List<Integer> TOTAL_LOTTO = new ArrayList<Integer>();

	private void lottoField() {
		for (int i = FIRST_NUM; i <= MAX_NUM; i++) {
			TOTAL_LOTTO.add(i);
		}
	}

	@Override
	public List<Integer> getLottoNum() {
		lottoField();
		List<Integer> lottoSet = new ArrayList<>();
		Collections.shuffle(TOTAL_LOTTO);

		for (int i = FIRST_NUM; i <= LAST_NUM; i++) {
			lottoSet.add(TOTAL_LOTTO.get(i));
		}

		Collections.sort(lottoSet);
		return lottoSet;
	}
}
