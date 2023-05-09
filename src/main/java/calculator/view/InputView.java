package calculator.view;

import calculator.domain.Operand;
import calculator.domain.Operator;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private final static String SEPARATOR = " ";
    private String formula;

    public InputView() {
        Scanner scanner = new Scanner(System.in);
        this.formula = scanner.nextLine();
    }

    public InputView(String formula) {
        this.formula = formula;
    }

    public List<Operand> getOperands() {
        if (formula == null || formula.isBlank()) {
            throw new IllegalArgumentException("null 또는 빈 공백 문자를 전달할 수 없습니다.");
        }

        return getOperands(formula.split(SEPARATOR));
    }

    public List<Operand> getOperands(String[] splited) {
        return IntStream.iterate(0, i -> i + 1)
                .limit(splited.length)
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> new Operand(splited[i]))
                .collect(Collectors.toList());
    }

    public List<Operator> getOperators() {
        if (formula == null || formula.isBlank()) {
            throw new IllegalArgumentException("null 또는 빈 공백 문자를 전달할 수 없습니다.");
        }

        return getOperators(formula.split(SEPARATOR));
    }

    public List<Operator> getOperators(String[] splited) {
        return IntStream.iterate(0, i -> i + 1)
                .limit(splited.length)
                .filter(i -> i % 2 == 1)
                .mapToObj(i -> new Operator(splited[i]))
                .collect(Collectors.toList());
    }
}
