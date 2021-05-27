package kht2199.lotto.data;

import java.util.Collections;
import java.util.List;

import kht2199.lotto.exception.LottoListEmptyException;

/**
 *
 * @author heetaek.kim
 */
public class LottoList {

	private final List<Lotto> list;

	public LottoList(List<Lotto> list) throws LottoListEmptyException {
		if (list == null || list.isEmpty()) {
			throw new LottoListEmptyException();
		}
		this.list = Collections.unmodifiableList(list);
	}

	public List<Lotto> getList() {
		return list;
	}

	public int size() {
		return list.size();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Lotto lotto : list) {
			sb.append(lotto.toString()).append('\n');
		}
		return sb.toString();
	}
}
