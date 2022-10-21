package step2.model;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class WinningLotto {

	private List<Integer> winNumList;

	public WinningLotto(List<Integer> winNumList) {
		this.winNumList = winNumList;
	}

	public int countMatch(Lotto lotto) {
		return winNumList.stream()
			.filter(
				target -> lotto.getLotto().stream().distinct().anyMatch(Predicate.isEqual(target)))
			.collect(Collectors.toList())
			.size();
	}

}
