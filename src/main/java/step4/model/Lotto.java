package step4.model;

import step4.util.LottoGenerator;

import java.util.Collections;
import java.util.List;

public class Lotto {
	private final List<Integer> numberList;

	public Lotto(LottoGenerator lottoGenerator) {
		this.numberList = lottoGenerator.generating();
	}

	public Lotto(final List<Integer> list){
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Lotto)) return false;

		Lotto lotto = (Lotto) o;

		return getNumberList() != null ? getNumberList().equals(lotto.getNumberList()) : lotto.getNumberList() == null;
	}

	@Override
	public int hashCode() {
		return getNumberList() != null ? getNumberList().hashCode() : 0;
	}

	public List<Integer> getNumberList() {
		return Collections.unmodifiableList(numberList);
	}
}
