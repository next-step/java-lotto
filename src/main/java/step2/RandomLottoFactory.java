package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoFactory implements LottoFactory{

	@Override
	public List<Integer> getLottoNum() {
		List<Integer> totalLottoNum = new ArrayList<Integer>();
		List<Integer> lottoSet = new ArrayList<>();

		for (int i = 1; i <= 45; i++) {
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
