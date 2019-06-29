package lotto.domain;

import common.NumberElement;
import lotto.model.LottoNumberCollection;
import lotto.model.LottoResult;
import lotto.model.LottoRule;
import lotto.exception.DuplicateNumberException;
import lotto.exception.OutOfMaxNumberException;
import common.NumberElementCollection;

public class LottoTicket {

	private static final String TO_STRING_FORMAT = "[%s]";

	LottoNumberCollection numbers = new LottoNumberCollection();

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
		return this.checkWin(winNumbers, null);
	}

	public LottoResult checkWin(NumberElementCollection winNumbers, NumberElement bonusNumber) {
		if(winNumbers.size() < LottoRule.MAX_COUNT){
			throw new IllegalArgumentException("당첨번호의 개수가 부족합니다.");
		}

		NumberElementCollection matchedNumbers = this.numbers.matchNumbers(winNumbers);
		LottoResult resultBasicMatch = LottoResult.valueOfMatchedCount(matchedNumbers.size());

		if(resultBasicMatch.equals(LottoResult.WIN_3RD)
				&& bonusNumber != null
				&& this.numbers.contains(bonusNumber)){

			return LottoResult.WIN_2ND;
		}

		return resultBasicMatch;
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
