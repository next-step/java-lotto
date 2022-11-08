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

	public int match(WinnerLotto winnerLotto){
		return (int) winnerLotto.getWinningNumber().stream()
				.mapToInt(hitNumber -> hitNumber)
				.filter(numberList::contains)
				.count();
	}

	public boolean checkBonus(WinnerLotto winnerLotto){
		return numberList.contains(winnerLotto.getBonusNumber());
	}

	public List<Integer> getNumberList() {
		return numberList;
	}
}
