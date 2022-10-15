import exception.NotFoundOperatorException;
import java.util.Arrays;

public class Calculator {
	public String isOperator(String operator){
		String[] op = new String[]{"+", "-", "*", "/"};

		return Arrays.stream(op)
			.filter(x -> x.equals(operator)).findAny()
			.orElseThrow(() -> new NotFoundOperatorException("연산자가 존재하지 않습니다"));
	}
}
