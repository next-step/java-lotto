package step1;

import java.util.Objects;


public class Calculator {
    Formula formula;
    private int answer;

    public Calculator(Formula formula) {
        this.formula = formula;
    }

    public void init() {
        answer = formula.getOperand().get(0);
    }
    
    public int execute() {
        
        for (int i = 0; i < formula.getOperator().size(); i++) {
            int withOperand = formula.getOperand().get(i +1);
            calculate(formula.getOperator().get(i), withOperand);
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