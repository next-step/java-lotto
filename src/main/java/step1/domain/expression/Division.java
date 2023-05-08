package step1.domain.expression;

import step1.domain.num.Num;

public class Division implements Expression {

    @Override
    public Num result(Num firstNum, Num secondNum) {
        return new Num(division(firstNum, secondNum));
    }

    private int division(Num firstNum, Num secondNum) {
        return firstNum.getNum() / secondNum.getNum();
    }
}
