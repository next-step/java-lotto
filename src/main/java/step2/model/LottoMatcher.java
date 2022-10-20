package step2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class LottoMatch {

	private List<Integer> winNumList;
	private static List<Integer> matchNumList;


	public LottoMatch(List<Integer> winNumList) {
		this.winNumList = winNumList;
		this.matchNumList = new ArrayList<>();
	}

	public void isMatch(Lotto lotto) {
		winNumList.stream()
			.filter(target -> lotto.getLotto().stream().anyMatch(Predicate.isEqual(target)))
			.forEach(target -> matchNumList.add(target));
	}

	public List<Integer> matchNum() {
		List<Integer> finalList = new ArrayList<>();
		for (int winNum : winNumList) {
			finalList.add(winNum, Collections.frequency(matchNumList, winNum));
		}

		return finalList;
	}
}
