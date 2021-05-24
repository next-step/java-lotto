package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DrawNumber {
	private final static int FIRST_INDEX = 0;

	private final List<Integer> numbers;

	private DrawNumber(List<Integer> numbers){
		// empty
		this.numbers = Collections.unmodifiableList(numbers);
	}

	public static DrawNumber range(int min, int max) {
		return new DrawNumber(IntStream.rangeClosed(min, max)
									   .boxed()
									   .collect(Collectors.toList()));
	}

	public List<Integer> draw(int size) {
		if (numbers.size() < size){
			return Collections.emptyList();
		}
		List<Integer> temp = new ArrayList<>();
		temp.addAll(numbers);
		Collections.shuffle(temp);
		return temp.subList(FIRST_INDEX, size);
	}
}
