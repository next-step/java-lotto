package lotto;

import lotto.exception.DuplicateNumberException;
import lotto.exception.OutOfMaxNumberException;
import model.NumberElementCollection;

public class LottoTicket {

	public static final int MAX_NUMBER = 45;

	public static final int MAX_COUNT = 6;

	NumberElementCollection numbers = new NumberElementCollection(MAX_COUNT);

	public void add(int number) {

		if(numbers.contains(number)){
			throw new DuplicateNumberException();
		}

		if(number > MAX_NUMBER){
			throw new OutOfMaxNumberException();
		}

		numbers.add(number);
	}

	public void add(int[] numbers) {
		for(int number : numbers){
			this.add(number);
		}
	}

	public LottoResult checkWin(NumberElementCollection winNumbers) {
		if(winNumbers.size() < MAX_COUNT){
			throw new IllegalArgumentException("당첨번호의 개수가 부족합니다.");
		}

		NumberElementCollection matchedNumbers = this.numbers.matchNumbers(winNumbers);
		return LottoResult.valueOfMatchedCount(matchedNumbers.size());
	}

	public boolean verify() {
		return numbers.size() == MAX_COUNT;
	}
}
