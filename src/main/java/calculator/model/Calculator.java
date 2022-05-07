package calculator.model;

import java.util.List;

public class Calculator {

    private final List<Number> numbers;
    private final List<Operator> operators;

    public Calculator(List<Number> numbers, List<Operator> operators) {
        validate(numbers, operators);
        this.numbers = numbers;
        this.operators = operators;
    }

    public int calculate() {
        Number res = numbers.get(0);
        int index = 1;

        for(Operator op: operators){
            res = res.calculate(op, numbers.get(index));
            index += 1;
        }

        return res.getNumber();
    }

    private void validate(List<Number> numbers, List<Operator> operators){
        if(numbers.size()  != operators.size() + 1){
            throw new IllegalArgumentException("잘못된 식입니다");
        }
    }
}
