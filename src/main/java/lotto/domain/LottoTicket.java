package lotto.domain;

import common.NumberElement;
import lotto.model.LottoNumberSet;
import lotto.model.LottoResult;
import lotto.model.LottoRule;
import lotto.model.WinNumber;

import java.util.List;

public class LottoTicket {

	private static final String TO_STRING_FORMAT = "[%s]";

	private LottoNumberSet numbers;

	private LottoTicket(LottoNumberSet numbers){
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

	@Override
	public String toString() {
		return String.format(TO_STRING_FORMAT, numbers);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		LottoTicket that = (LottoTicket) o;

		return numbers.equals(that.numbers);
	}

	@Override
	public int hashCode() {
		return numbers.hashCode();
	}

	public static LottoTicket of(int[] numbers){

		return new LottoTicket(LottoNumberSet.of(numbers));
	}

	public static LottoTicket of(LottoNumberSet numbers) {
		return new LottoTicket(numbers);
	}

}
