package generate;

import domain.Number;
import util.InputValidation;

import java.util.ArrayList;
import java.util.List;

public class PlusCalculate {
	public Integer excute (String input) {
		if (InputValidation.checkNullAndEmpty(input)) {
			return 0;
		}

		if (InputValidation.checkSingle(input)) {
			return Integer.parseInt(input);
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
