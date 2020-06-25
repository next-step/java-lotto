package study4.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import study4.domain.Ranking.Rank;

public class Lotto {

	static final int MAX_LOTTO_NUMBER = 45;
	static final int MIN_LOTTO_NUMBER = 1;
	
	private List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		for (int i : numbers) {
			isWrongNumberList(i);
			this.numbers = numbers;
		}
	}

	private void isWrongNumberList(int i) {
		if (isWrongNumber(i)) {
			throw new IllegalArgumentException("로또 번호는 1~45까지 입니다.");
		}
	}

	private boolean isWrongNumber(int number) {
		return number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER;
	}

	
	public List<Integer> getNumbers() {
		return Collections.unmodifiableList(numbers);
	}
	
	public  Rank getRankWithWinningLotto(List<Integer> winningLotto, Boolean bonusBallFlag) {
								
		int matchedNumber =  (int) this.numbers.stream()
				        .filter(winningLotto::contains)
				        .count();
		
		return Ranking.getRanking(matchedNumber, bonusBallFlag);
	}

	public boolean lottoContainsBonusBall(int bonusBall) {
		return this.numbers.contains(bonusBall);
	}
}
