package step3.model;

import step3.util.LottoGenerator;

import java.util.List;

public class Lotto {
	private final List<Integer> numberList;

	public Lotto(LottoGenerator lottoGenerator) {
		this.numberList = lottoGenerator.generating();
	}

	public List<Integer> getNumberList() {
		return numberList;
	}
}
