package step1;

import java.util.Arrays;
import java.util.List;

public class Separator {
	private final List<String> formula;
	public Separator(String input) {
		formula = Arrays.asList(input.split(" "));
	}

	public List<String> getFormula() {
		return formula;
	}
}
