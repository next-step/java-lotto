package lotto;

import lotto.exception.DuplicateNumberException;
import lotto.exception.OutOfCountException;
import lotto.exception.OutOfMaxNumberException;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

	public static final int MAX_NUMBER = 45;

	private static final int MAX_COUNT = 6;

	List<Integer> numbers = new ArrayList<>();

	public void add(int number) {
		if(numbers.contains(number)){
			throw new DuplicateNumberException();
		}

		if(numbers.size() == MAX_COUNT){
			throw new OutOfCountException();
		}

		if(number > MAX_NUMBER){
			throw new OutOfMaxNumberException();
		}

		numbers.add(number);
	}
}
