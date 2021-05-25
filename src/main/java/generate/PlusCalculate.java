package generate;

import domain.Number;
import util.ExceptionMessage;
import util.InputValidation;

import java.util.ArrayList;
import java.util.List;

public class PlusCalculate {
	public Integer excute (List<Integer> numbers) {
		List<Number> numberList = new ArrayList<>();

		for (Integer number : numbers) {
			numberList.add(new Number(number));
		}

		return plus(numberList);
	}

	private Integer plus(List<Number> numberList) {
		Integer result = 0;
		for (Number number : numberList) {
			result += number.number();
		}
		return result;
	}
}
