import domain.ArithmeticSign;
import domain.Number;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calculator {

    private List<ArithmeticSign> arithmeticSigns = new ArrayList<>();
    private List<Number> numbers = new ArrayList<>();

    Calculator(List<String> resource) {
        ;
        seperate(resource);
        validSeperatedResource();
    }

    private void validSeperatedResource() {
        if (numbers.size() != arithmeticSigns.size() + 1) {
            throw new IllegalArgumentException("숫자와 사칙연산 짝이 맞지 않습니다.");
        }

        if (numbers.isEmpty() || numbers.size() == 0) {
            throw new IllegalArgumentException("숫자와 사칙연산 짝이 맞지 않습니다.");
        }

        if (arithmeticSigns.isEmpty() || arithmeticSigns.size() == 0) {
            throw new IllegalArgumentException("숫자와 사칙연산 짝이 맞지 않습니다.");
        }
    }

    private void seperate(List<String> resource) {
        numbers = IntStream.range(0, resource.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> new Number(resource.get(i)))
                .collect(Collectors.toList());
        arithmeticSigns = IntStream.range(0, resource.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> ArithmeticSign.of(resource.get(i)))
                .collect(Collectors.toList());
    }

    public Number calculate() {
        Number result = numbers.get(0);
        for (int i = 0; i < arithmeticSigns.size(); i++) {
            ArithmeticSign arithmeticSign = arithmeticSigns.get(i);
            result = arithmeticSign.doArithmetic(result, numbers.get(i + 1));
        }
        return result;
    }


}
