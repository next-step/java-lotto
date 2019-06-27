package lotto;

import lotto.exception.DuplicateNumberException;
import lotto.exception.OutOfMaxNumberException;
import model.NumberElementCollection;

import java.util.Collections;

public class LottoTicket {

	private static final String TO_STRING_FORMAT = "[%s]";

	NumberElementCollection numbers = new NumberElementCollection(LottoRule.MAX_COUNT);

	private LottoTicket(){
		// 기본생성자는 클래스메서드에서만 접근
	}

	private void add(int value) {

		if(numbers.contains(value)){
			throw new DuplicateNumberException();
		}

		if(value > LottoRule.MAX_NUMBER){
			throw new OutOfMaxNumberException();
		}

		numbers.add(value);

	}

	public void add(int[] values) {
		for(int value : values){
			this.add(value);
		}

		numbers.sort();	// 정렬상태 유지
	}


	public LottoResult checkWin(NumberElementCollection winNumbers) {
		if(winNumbers.size() < LottoRule.MAX_COUNT){
			throw new IllegalArgumentException("당첨번호의 개수가 부족합니다.");
		}

		NumberElementCollection matchedNumbers = this.numbers.matchNumbers(winNumbers);
		return LottoResult.valueOfMatchedCount(matchedNumbers.size());
	}

	public boolean verify() {
		return numbers.size() == LottoRule.MAX_COUNT;
	}

	@Override
	public String toString() {
		return String.format(TO_STRING_FORMAT, numbers);
	}

	public static LottoTicket of(int[] numbers){
		LottoTicket ticket = new LottoTicket();
		ticket.add(numbers);

		return ticket;
	}
}
