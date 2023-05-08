package step1.domain.expression;

import step1.domain.num.Num;

public interface Expression {
    Num result(Num firstNum, Num secondNum);
}
