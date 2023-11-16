package lotto;

import java.util.Iterator;
import java.util.List;

public class LottoList implements Iterable<Lotto> {
	private final List<Lotto> lottoList;

	public LottoList(List<Lotto> lottoList) {
		checkLottoListSizeIsValid(lottoList);
		this.lottoList = lottoList;
	}

	private void checkLottoListSizeIsValid(List<Lotto> lottoList) {
		if(lottoList == null || lottoList.isEmpty()) {
			throw new IllegalArgumentException("최소 1개 이상의 로또가 필요 합니다.");
		}
	}

	@Override
	public Iterator<Lotto> iterator() {
		return lottoList.iterator();
	}

	public int size() {
		return this.lottoList.size();
	}
}
