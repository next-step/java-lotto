package lottery.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomUtil {

	public static List<Integer> generateSixNumbers(final int startInclusive, final int endInclusive){
		List<Integer> numbers = new ArrayList<>();
		for (int i = startInclusive; i <= endInclusive ; i++) {
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		List<Integer> ticketNumbers = numbers.subList(0, 6);
		Collections.sort(ticketNumbers);
		return ticketNumbers;
	}
}
