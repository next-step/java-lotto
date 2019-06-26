package lotto;

import lotto.exception.DuplicateNumberException;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

	List<Integer> numbers = new ArrayList<>();

	public void add(int number) {
		if(numbers.contains(number)){
			throw new DuplicateNumberException();
		}

		numbers.add(number);
	}
}
