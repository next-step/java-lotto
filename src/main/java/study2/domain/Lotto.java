package study2.domain;

import java.util.List;
import java.util.stream.Collectors;

import study2.domain.Ranking.Rank;

public class Lotto {

	static final int MAX_LOTTO_NUMBER = 45;
	static final int MIN_LOTTO_NUMBER = 1;
	private int number;
	private List<Integer> numbers;

	public Lotto() {

	}

	public Lotto(int number) {
		isWrongNumberList(number);
		this.number = number;
	}

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

	public int getNumber() {
		return number;
	}
	public List<Integer> getNumbers() {
		return numbers;
	}
	public int size() {
		return numbers.size();
	}

	public int getRankWithWinningLotto(List<Integer> winningLotto) {
		
		System.out.println("this.numbers" + this.numbers);
		System.out.println("winningLotto" + winningLotto);
		
		
		System.out.println(this.numbers.stream()
                .filter(winningLotto::contains)
                .count());
				
		return  (int) this.numbers.stream()
                .filter(winningLotto::contains)
                .count();
		
	}

	
}
