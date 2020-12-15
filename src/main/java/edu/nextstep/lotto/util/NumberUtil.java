package edu.nextstep.lotto.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberUtil {

	private NumberUtil() {
	}

	public static List<Integer> generateSortedRandomNumber(int start, int end, int size) {
		rangeCheck(start, end, size);
		List<Integer> totalNumbers = IntStream.rangeClosed(start, end)
			.boxed()
			.collect(Collectors.toList());
		Collections.shuffle(totalNumbers);
		List<Integer> randomNumbers = totalNumbers.subList(0, size);
		Collections.sort(randomNumbers);
		return randomNumbers;
	}

	public static void rangeCheck(int start, int end, int size) {
		if (start > end) {
			throw new IllegalArgumentException("start가 end보다 클 수 없습니다.");
		}
		if (size < 1) {
			throw new IllegalArgumentException("size는 1보다 작을 수 없습니다.");
		}
		if (end - start + 1 < size) {
			throw new IllegalArgumentException("범위 내 숫자의 개수 보다 size가 큽니다.");
		}
	}
}
