package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleMakeStrategy implements MakeStrategy {
	List<LottoNumber> lottoNumbers = new ArrayList<>();

	@Override
	public List<LottoNumber> makeGameNumberList() {
		getLottoNumbers();
		Collections.shuffle(lottoNumbers);

		List<LottoNumber> gameNumberList = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			gameNumberList.add(lottoNumbers.get(i));
		}

		return gameNumberList;
	}

	private void getLottoNumbers() {
		if (lottoNumbers.isEmpty()) {
			makeNewLottoNumbers();
		}
	}

	private void makeNewLottoNumbers() {
		for (int i = 1; i <= 45; i++) {
			this.lottoNumbers.add(new LottoNumber(i));
		}
	}

}
