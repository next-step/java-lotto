package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberList {
	private final List<LottoNumber> lottoNumberList = new ArrayList<>();

	public LottoNumberList() {
		for (int i = 1; i <= 45; i++) {
			lottoNumberList.add(new LottoNumber(i));
		}
	}

	public List<LottoNumber> getLottoNumberList() {
		return lottoNumberList;
	}
}
