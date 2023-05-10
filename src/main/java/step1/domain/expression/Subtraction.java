package step1.domain.expression;

import step1.domain.num.Num;

public class Subtraction implements Expression {

    @Override
    public Num result(Num firstNum, Num secondNum) {
        return new Num(subtraction(firstNum, secondNum));
    }

    private int subtraction(Num firstNum, Num secondNum) {
        return firstNum.getNum() - secondNum.getNum();
    }

}
