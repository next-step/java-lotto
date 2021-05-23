package automaticLotto;

import java.util.List;

public class Lottos {
	public static final int MAXIMUM_LOTTOS_SIZE = 100;

	final List<Lotto> lottos;

	public Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
		validateLottosSize();
	}

	private void validateLottosSize() {
		if (this.lottos.size() > MAXIMUM_LOTTOS_SIZE) {
			throw new RuntimeException("the size of lottos can not exceed 100");
		}
	}

	public int size() {
		return this.lottos.size();
	}
}
