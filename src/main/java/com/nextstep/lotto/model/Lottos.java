package com.nextstep.lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

	private List<Lotto> lottos;

	public Lottos(int lottoCount) {
		lottos = new ArrayList<>();
		for (int i = 0; i < lottoCount; i++) {
			lottos.add(new Lotto());
		}
	}

	public List<Lotto> getLottos() {
		return lottos;
	}
}
