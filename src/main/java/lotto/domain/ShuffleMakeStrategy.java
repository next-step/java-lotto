package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleMakeStrategy implements MakeStrategy {

	@Override
	public List<LottoNumber> makeGameNumberList() {
		List<LottoNumber> gameNumberList = new ArrayList<>();
		LottoNumberList numberList = new LottoNumberList();
		Collections.shuffle(numberList.getLottoNumberList());
		for (int i = 0; i < 6; i++) {
			gameNumberList.add(numberList.getLottoNumberList().get(i));
		}

		return gameNumberList;
	}

}
