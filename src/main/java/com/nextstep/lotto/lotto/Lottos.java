package com.nextstep.lotto.lotto;

import java.util.ArrayList;
import java.util.List;

import com.nextstep.lotto.utill.Printable;

public class Lottos implements Printable {

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

	@Override
	public void print() {
		for (Lotto lotto : lottos) {
			lotto.print();
		}
	}
}
