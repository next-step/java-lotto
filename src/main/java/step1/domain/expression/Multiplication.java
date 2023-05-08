package step1.domain.expression;

import step1.domain.num.Num;

public class Multiplication implements Expression{

    @Override
    public Num result(Num firstNum, Num secondNum) {
        return new Num(multiplication(firstNum, secondNum));
    }

    private int multiplication(Num firstNum, Num secondNum) {
        return firstNum.getNum() * secondNum.getNum();
    }
}
