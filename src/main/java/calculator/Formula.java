package calculator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Formula {

	private static final BlankSeparator DEFAULT_SEPARATOR = new BlankSeparator();

	private final StringSeparator separator;

	private Queue<String> splitedFormula;

	private Formula(StringSeparator separator, List<String> splitedFormula) {
		validateFormula(splitedFormula);
		this.separator = separator;
		this.splitedFormula = new LinkedList(splitedFormula);
	}

	public Formula(String input) {
		this(DEFAULT_SEPARATOR, DEFAULT_SEPARATOR.separate(input));
	}

	public Formula(StringSeparator separator, String input) {
		this(separator, separator.separate(input));
	}

	private static void validateFormula(List<String> splitedFormula) {
		// 완성된 계산식은 숫자 + 연산자의 갯수가 홀수여야한다.
		if (splitedFormula.size() % 2 != 1) {
			throw new IllegalArgumentException("잘못된 계산식 입니다.");
		}
	}

	public String get() {
		return splitedFormula.poll();
	}

	public boolean isEnd() {
		return splitedFormula.isEmpty();
	}

}
