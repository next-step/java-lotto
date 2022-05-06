package model;

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
        int res = numbers.get(0).getNumber();
        int index = 1;

        for(Operator op: operators){
            res = op.calculate(res, numbers.get(index).getNumber());
            index += 1;
        }

        return res;
    }

    private void validate(List<Number> numbers, List<Operator> operators){
        if(numbers.size()  != operators.size() + 1){
            throw new IllegalArgumentException("잘못된 식입니다");
        }
    }
}
