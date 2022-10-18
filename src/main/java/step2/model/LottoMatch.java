package step2.model;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import step2.model.Lotto;

public class LottoMatch {

	private List<Integer> winNumList;

	public LottoMatch(List<Integer> winNumList) {
		this.winNumList = winNumList;
	}

	public List<Integer> isMatch(Lotto lotto) {
		return winNumList.stream()
			.filter(target -> lotto.getLotto().stream().anyMatch(Predicate.isEqual(target)))
			.collect(Collectors.toList());

	}
}
