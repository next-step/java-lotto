package kht2199.lotto;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author heetaek.kim
 */
public class LottoList {

	/**
	 * unmodifiable list.
	 */
	private List<Lotto> list = Collections.emptyList();

	public boolean isNotEmpty() {
		return !list.isEmpty();
	}

	public void setList(List<Lotto> list) {
		this.list = Collections.unmodifiableList(list);
	}
}
