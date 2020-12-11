package stringaddcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author : byungkyu
 * @date : 2020/12/11
 * @description :
 **/
public class Numbers {
	private static final String REGEX = ",|:";

	private List<Integer> numbers;

	public Numbers(String target) {
		String[] splits = split(target);
		numbers = Arrays.stream(splits)
			.map(str -> parser(str))
			.collect(Collectors.toList());
	}

	private int parser(String str) {
		int result = 0;
		try{
			result = Integer.parseInt(str);
		}catch (NumberFormatException e){
			throw new IllegalArgumentException("입력된 숫자가 올바르지 않습니다.");
		}
		return result;
	}

	private String[] split(String target) {
		return target.split(REGEX);
	}

	public int sum() {
		return numbers.stream()
			.reduce((x, y) -> x + y)
			.orElseThrow(() -> new IllegalArgumentException("연산을 수행할 수 없습니다."));
	}
}
