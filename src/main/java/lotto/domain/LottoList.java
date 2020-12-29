package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoList {

	private List<Lotto> lottoList = new ArrayList<>();

	public LottoList(List<Lotto> manualLottoList, int autoLottoCount) {
		List<Lotto> autoLottoList  = new ArrayList<>();
		for (int i = 0; i < autoLottoCount; i++) {
			autoLottoList.add(new Lotto(Lotto.getShuffleNumbers()));
		}

		this.lottoList.addAll(manualLottoList);
		this.lottoList.addAll(autoLottoList);
	}

	public List<Lotto> getLottoList() {
		return lottoList;
	}
}
