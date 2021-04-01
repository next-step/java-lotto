package im.juniq.lotto.domain;

import java.util.List;

public interface ShuffleStrategy {
	void shuffle(List<Integer> baseNumbers);
}
