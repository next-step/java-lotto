package StringCalculator.controller;

import StringCalculator.domain.Calculator;
import StringCalculator.domain.Expression;
import StringCalculator.domain.Operand;
import StringCalculator.domain.Operator;
import StringCalculator.view.InputView;

import java.util.List;

public class StringCalculator {
        public static void main(String[] args) {
                Expression expression = InputView.getExpression();
                List<Operand> operands = expression.getOperands();
                List<Operator> operators = expression.getOperators();

                int result = Calculator.calculate(operands, operators);

                System.out.println(result);
        }
}
