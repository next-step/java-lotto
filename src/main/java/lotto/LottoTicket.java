package lotto;

import lotto.exception.DuplicateNumberException;
import lotto.exception.OutOfCountException;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

	private static final int MAX_COUNT = 6;

	List<Integer> numbers = new ArrayList<>();

	public void add(int number) {
		if(numbers.contains(number)){
			throw new DuplicateNumberException();
		}

		if(numbers.size() == MAX_COUNT){
			throw new OutOfCountException();
		}

		numbers.add(number);
	}
}
