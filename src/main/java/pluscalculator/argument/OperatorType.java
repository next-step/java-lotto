package pluscalculator.argument;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OperatorType {
	ONLY_ONE_NUMBER(Operator.NONE) {
		@Override
		public Operands toOperandsFrom(String input) {
			return Operands.from(new String[]{input});
		}
	},
	DEFAULT(Operator.PLUS) {
		@Override
		public Operands toOperandsFrom(String input) {
			String[] operandArray = getSplitedInput(input);
			return Operands.from(operandArray);
		}

	},
	CUSTOM(Operator.PLUS) {
		@Override
		public Operands toOperandsFrom(String input) {
			Matcher matcher = CUSTOM_PATTERN.matcher(input);
			if (!matcher.find()) {
				throw new IllegalArgumentException("커스텀 패턴에 맞지 않는 입력값입니다.");
			}
			String customDelimiter = matcher.group(1);
			String[] operandArray = matcher.group(2).split(customDelimiter);

			return Operands.from(operandArray);
		}

	};

	private static final Pattern NUMBER_PATTERN = Pattern.compile("^[-+]?(0|[1-9][0-9]*)(\\\\.[0-9]+)?([eE][-+]?[0-9]+)?$");
	private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\\\\n(.*)");
	private static final String DEFAULT_TYPE_DELIMITER = ",|:";

	private static boolean isAllDualNumber(String[] operandArray) {
		if (operandArray.length <= 1) {
			return false;
		}
		return Stream.of(operandArray)
					 .allMatch(operand -> doesMatchPattern(operand, NUMBER_PATTERN) && isDualNumber(operand));
	}

	private static boolean isOnlyOneNumber(String[] operandArray) {
		if (operandArray.length != 1) {
			return false;
		}
		String operand = operandArray[0];
		return doesMatchPattern(operand, NUMBER_PATTERN) && isDualNumber(operand);
	}

	private static boolean doesFindPattern(String operand, Pattern pattern) {
		return pattern.matcher(operand)
					  .find();
	}

	private static boolean doesMatchPattern(String operand, Pattern pattern) {
		return pattern.matcher(operand)
					  .matches();
	}

	private static boolean isDualNumber(String operand) {
		if (Integer.parseInt(operand) >= 0) {
			return true;
		}
		throw new IllegalArgumentException("음수는 입력하시면 안 됩니다.");
	}

	private static String[] getSplitedInput(String input) {
		return input.split(DEFAULT_TYPE_DELIMITER);
	}

	public static OperatorType getOperatorTypeBy(String input) {
		String[] operandArray = getSplitedInput(input);
		if (isOnlyOneNumber(operandArray)) {
			return ONLY_ONE_NUMBER;
		}
		if (isAllDualNumber(operandArray)) {
			return DEFAULT;
		}

		String[] operandArrayForCustomPattern = CUSTOM.toOperandsFrom(input).toStringArray();
		if (doesFindPattern(input, CUSTOM_PATTERN) && isAllDualNumber(operandArrayForCustomPattern)) {
			return CUSTOM;
		}
		throw new IllegalArgumentException("연산자를 다시 확인해주세요.");
	}

	private Operator operator;

	public abstract Operands toOperandsFrom(String input);
}
