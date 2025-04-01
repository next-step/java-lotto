package com.nextstep.camp.calculator.domain.strategy;

import com.nextstep.camp.calculator.domain.vo.ExpressionTokens;
import com.nextstep.camp.common.strategy.InputStrategy;

import java.util.Scanner;

public class ExpressionInputStrategy implements InputStrategy<ExpressionTokens> {
    private final Scanner scanner;

    private ExpressionInputStrategy(Scanner scanner) {
        this.scanner = scanner;
    }

    public static ExpressionInputStrategy ofSystemIn() {
        Scanner scanner = new Scanner(System.in);
        return new ExpressionInputStrategy(scanner);
    }

    public static ExpressionInputStrategy of(Scanner scanner) {
        return new ExpressionInputStrategy(scanner);
    }

    @Override
    public ExpressionTokens read() {
        return ExpressionTokens.of(scanner.nextLine());
    }
}
