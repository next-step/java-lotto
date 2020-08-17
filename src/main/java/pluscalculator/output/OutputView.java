package pluscalculator.output;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import pluscalculator.result.CalculatorResult;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OutputView {

	public static void output(CalculatorResult result) {
		System.out.println(String.format("결과는 %s 입니다.", result.viewResult()));
	}
}
