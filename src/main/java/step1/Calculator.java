package step1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Calculator {
    Operator operator;
    private List<Integer> operand;

    private int answer;

    public Calculator(Formula formula) {
        this.operand = formula.getOperand();
        this.operator = formula.getOperator();
    }

    public void init() {
        answer = operand.get(0);
    }
    
    public int execute() {
        
        for (int i = 0; i < this.operator.size(); i++) {
            calculate(this.operator.get(i), this.operand.get(i +1));
        }

        return answer;
    }

    private void calculate(String operator, int withOperand) {

        if (Objects.equals(operator, "*")) {
            multiply(withOperand);
        }
        if (Objects.equals(operator, "/")) {
            divide(withOperand);
        }
        if (Objects.equals(operator, "-")) {
            minus(withOperand);
        }
        if (Objects.equals(operator, "+")) {
            plus(withOperand);
        }
    }

    private void multiply(int withOperand) {
        answer *= withOperand;
    }

    private void divide(int withOperand) {
        answer /= withOperand;
    }

    private void minus(int withOperand) {
        answer -= withOperand;
    }

    private void plus(int withOperand) {
        answer += withOperand;
    }
}