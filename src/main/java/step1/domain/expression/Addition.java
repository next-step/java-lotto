package step1.domain.expression;

import step1.domain.num.Num;

public class Addition implements Expression {

    public Num result(Num firstNum, Num secondNum) {
        return new Num(addition(firstNum, secondNum));
    }

    public int addition(Num firstNum, Num secondNum) {
        return firstNum.getNum() + secondNum.getNum();
    }

}
