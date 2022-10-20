package step2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import step2.model.LottoFactory;

public class RandomLottoFactory implements LottoFactory {

	private static final int FIRST_NUM = 1;
	private static final int LAST_NUM = 45;

	@Override
	public List<Integer> getLottoNum() {
		List<Integer> totalLottoNum = new ArrayList<Integer>();
		List<Integer> lottoSet = new ArrayList<>();

		for (int i = FIRST_NUM; i <= LAST_NUM; i++) {
			totalLottoNum.add(i);
		}

		Collections.shuffle(totalLottoNum);

		for (int i = 0; i < 6; i++) {
			lottoSet.add(totalLottoNum.get(i));
		}

		Collections.sort(lottoSet);
		return lottoSet;
	}
}
