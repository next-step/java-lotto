package step3.model;

import step3.util.LottoGenerator;

import java.util.HashSet;
import java.util.List;

public class Lotto {
	private final List<Integer> numberList;

	public Lotto(LottoGenerator lottoGenerator) {
		this.numberList = lottoGenerator.generating();
	}

	public Lotto(List<Integer> list){
		this.numberList = list;
	}

	public List<Integer> getNumberList() {
		return numberList;
	}
}
