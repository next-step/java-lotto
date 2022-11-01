package step2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoFactory implements LottoFactory {

	private static final int FIRST_NUM = 1;
	private static final int MAX_NUM = 45;
	private static final int LAST_NUM = 6;
	private List<Integer> totalLotto;

	private void lottoField() {
		totalLotto = new ArrayList<>();
		for (int i = FIRST_NUM; i <= MAX_NUM; i++) {
			totalLotto.add(i);
		}
	}

	@Override
	public List<Integer> getLottoNum() {
		lottoField();
		List<Integer> lottoSet = new ArrayList<>();
		Collections.shuffle(totalLotto);

		for (int i = FIRST_NUM; i <= LAST_NUM; i++) {
			lottoSet.add(totalLotto.get(i));
		}

		Collections.sort(lottoSet);
		return lottoSet;
	}
}
