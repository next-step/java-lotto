package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleMakeStrategy implements MakeStrategy {

	@Override
	public List<LottoNumber> makeGameNumberList() {
		List<LottoNumber> lottoNumbers = lottoNumbers();
		Collections.shuffle(lottoNumbers);

		List<LottoNumber> gameNumberList = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			gameNumberList.add(lottoNumbers.get(i));
		}

		return gameNumberList;
	}

	private List<LottoNumber> lottoNumbers() {
		List<LottoNumber> lottoNumbers = new ArrayList<>();
		for (int i = 1; i <= 45; i++) {
			lottoNumbers.add(new LottoNumber(i));
		}
		return lottoNumbers;
	}

}
