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

    public Calculator(List<Number> numbers, List<Operator> operators) {
        this.numbers = numbers;
        this.operators = operators;
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
