package lotto;

import lotto.exception.DuplicateNumberException;
import lotto.exception.OutOfCountException;
import lotto.exception.OutOfMaxNumberException;
import model.NumberElementCollection;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

	public static final int MAX_NUMBER = 45;

	private static final int MAX_COUNT = 6;

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

	public int checkWin(NumberElementCollection winNumbers) {
		return 0;
	}
}
