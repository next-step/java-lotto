package generate;

import domain.Number;

import java.util.ArrayList;
import java.util.List;

public class PlusCalculate {
	public Integer excute (String input) {
		if (input == null ||input.equals("")) {
			return 0;
		}

		List<Number> numberList = new ArrayList<>();

		for (String number : Separator.split(input)) {
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
