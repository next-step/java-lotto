package kr.heesu.calculator.domain;

import java.util.List;

public class Arguments {
    private List<Number> args;

    private Arguments(List<Number> numbers) {
        this.args = numbers;
    }

    public boolean hasNext() {
        return !args.isEmpty();
    }

    public int nextArgument() {
        Number next = this.args.remove(0);
        return next.getVal();
    }

    public static Arguments of(List<Number> numbers) {
        return new Arguments(numbers);
    }
}
