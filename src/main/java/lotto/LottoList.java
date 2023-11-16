package lotto;

import java.util.Iterator;
import java.util.List;

public class LottoList implements Iterable<Lotto> {
	private final List<Lotto> lottoList;

	public LottoList(List<Lotto> lottoList) {
		this.lottoList = lottoList;
	}

	@Override
	public Iterator<Lotto> iterator() {
		return lottoList.iterator();
	}

	public int size() {
		return this.lottoList.size();
	}
}
