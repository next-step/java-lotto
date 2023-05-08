package step1.domain.calculator;

import step1.domain.expression.Expression;
import step1.domain.num.Num;
import step1.domain.num.Nums;

public class Calculator {
    private Num result;

    public Calculator() {
        result = new Num(0);
    }

    public Calculator(Num result) {
        this.result = result;
    }

    public void calculate(Num secondNum, Expression expression) {
        this.result = expression.result(this.result, secondNum);
    }

    public void calculate(Nums nums, Expression expression) {
        this.result = expression.result(nums.firstNum(), nums.secondNum());
    }

    public Num result() {
        return result;
    }

}
