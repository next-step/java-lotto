package calculator;

import calculator.operator.Operator;
import calculator.validator.StringCalculatorValidator;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalculator {

    private static final String STRING_DELIMITER = " ";

    public static int calculate(String input) {
        StringCalculatorValidator.validateOrThrow(input);

        List<String> splitInputStrings = split(input);
        List<Integer> operands = extractOperands(splitInputStrings);
        List<Operator> operators = extractOperator(splitInputStrings);

        return execOperators(operands, operators);
    }

    private static int execOperators(List<Integer> operands, List<Operator> operators) {
        int intermediateResult = operands.get(0);
        int secondOperandIndex = 1;
        for (Operator operator : operators) {
            intermediateResult = operator.exec(intermediateResult, operands.get(secondOperandIndex));
            secondOperandIndex++;
        }

        return intermediateResult;
    }

    private static List<String> split(String input) {
        if (Objects.isNull(input)) {
            return Collections.emptyList();
        }

        return Collections.unmodifiableList(List.of(input.split(STRING_DELIMITER)));
    }

    private static List<String> getOddOrEvenIndexStrings(List<String> inputStrings, boolean isOdd) {
        int remainder = isOdd ? 1 : 0;
        return IntStream.range(0, inputStrings.size())
                        .filter(idx -> idx % 2 == remainder)
                        .mapToObj(inputStrings::get)
                        .collect(Collectors.toList());
    }

    private static List<String> getOddIndexStrings(List<String> inputStrings) {
        return getOddOrEvenIndexStrings(inputStrings, true);
    }

    private static List<String> getEvenIndexStrings(List<String> inputStrings) {
        return getOddOrEvenIndexStrings(inputStrings, false);
    }

    private static List<Integer> extractOperands(List<String> inputStrings) {
        return getEvenIndexStrings(inputStrings).stream()
                                                .map(Integer::parseInt)
                                                .collect(Collectors.toList());
    }

    private static List<Operator> extractOperator(List<String> inputStrings) {
        return getOddIndexStrings(inputStrings).stream()
                                               .map(Operator::valueOf)
                                               .collect(Collectors.toList());
    }
}
