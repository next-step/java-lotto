package controller;

import domain.Operator;
import domain.Number;
import domain.OperatorFactory;
import util.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Calculator {
    private final List<Number> numbers;
    private final List<Operator> operators;

    public Calculator(String expression) {
        this(Parser.parse(expression));
    }

    public Calculator(String[] expression) {
        this(parseNumbers(expression), parseOperators(expression));
    }

    public Calculator(List<Number> numbers, List<Operator> operators) {
        this.numbers = numbers;
        this.operators = operators;
    }

    private static String[] parseExpressions(String expression) {
        return expression.split(" ");
    }

    private static List<Number> parseNumbers(String[] expression) {
        List<Number> numbers = new ArrayList<>();

        for (int i = 0; i < expression.length; i+=2) {
            numbers.add(new domain.Number(expression[i]));
        }

        return numbers;
    }

    private static List<Operator> parseOperators(String[] expression) {
        List<Operator> operators = new ArrayList<>();
        for (int i = 1; i < expression.length - 1; i+=2) {
            operators.add(OperatorFactory.getOperator(expression[i]));
        }

        return operators;
    }

    public Number calculate() {
        Number result = numbers.getFirst();

        for (int i = 1; i < numbers.size(); i++) {
            result = result.calculate(operators.get(i - 1), numbers.get(i));
        }

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Calculator that = (Calculator) o;
        return Objects.equals(numbers, that.numbers) && Objects.equals(operators, that.operators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers, operators);
    }
}
