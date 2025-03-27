package step1.controller;

import step1.domain.Calculator;
import step1.domain.Expression;
import step1.domain.Operand;
import step1.domain.Operator;
import step1.view.InputView;

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
