package lotto.domain;

import common.NumberElement;
import lotto.model.LottoNumberSet;
import lotto.model.LottoResult;
import lotto.model.LottoRule;
import lotto.model.WinNumber;

import java.util.List;

public class LottoTicket {

	private static final String TO_STRING_FORMAT = "[%s]";

	LottoNumberSet numbers;

	private LottoTicket(LottoNumberSet numbers){
		// 기본생성자는 클래스메서드에서만 접근
		this.numbers = numbers;
	}


	public LottoResult checkWin(WinNumber winNumber) {
		List<NumberElement> matchedNumbers = this.numbers.matchNumbers(winNumber.getPrimary());
		LottoResult resultBasicMatch = LottoResult.valueOfMatchedCount(matchedNumbers.size());

		if(resultBasicMatch.equals(LottoResult.WIN_3RD)
				&& this.numbers.contains(winNumber.getBonus())){

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

		return new LottoTicket(LottoNumberSet.of(numbers));
	}
}
