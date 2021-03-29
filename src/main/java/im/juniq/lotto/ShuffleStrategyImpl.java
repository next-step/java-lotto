package im.juniq.lotto;

import java.util.Collections;
import java.util.List;

public class ShuffleStrategyImpl implements ShuffleStrategy {
	@Override
	public void shuffle(List<Integer> baseNumbers) {
		Collections.shuffle(baseNumbers);
	}
}
