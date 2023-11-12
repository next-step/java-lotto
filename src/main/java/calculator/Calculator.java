package calculator;

import static calculator.Addition.ADDITION;
import static calculator.Division.DIVISION;
import static calculator.Multiplication.MULTIPLICATION;
import static calculator.Subtraction.SUBTRACTION;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Calculator {

        private List<String> operators = List.of(ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION);
        private Queue<Integer> queueOfNumbers = new LinkedList<>();
        private Queue<String> queueOfOperators = new LinkedList<>();

        private int result;
        private boolean alreadyExecutedOperateFunction;

        public int calculate(String arithmeticText) {
                if (isEmptyOrNull(arithmeticText)) {
                        throw new IllegalArgumentException("사칙연산을 입력해주세요.");
                }
                String[] texts = TextManipulator.splitByEmptyText(arithmeticText);
                Arrays.stream(texts).forEach(this::splitNumberAndOperator);
                while (!queueOfOperators.isEmpty()) {
                        operate();
                }
                return result;
        }

        private boolean isEmptyOrNull(String text) {
                return text == null || text.isEmpty();
        }

        private void splitNumberAndOperator(String text) {
                if (TextManipulator.isNumericText(text)) {
                        queueOfNumbers.add(Integer.valueOf(text));
                        return;
                }
                if (isNotOperator(text)) {
                        throw new IllegalArgumentException("잘못된 사칙연산 기호를 입력하였습니다.");
                }
                if (!TextManipulator.isNumericText(text)) {
                        queueOfOperators.add(text);
                }
        }

        private boolean isNotOperator(String text) {
                return !operators.contains(text);
        }

        private void operate() {
                String currentOperator = (queueOfOperators.poll());
                if (isFirstExecution()) {
                        result = getFirstNumber();
                        alreadyExecutedOperateFunction = true;
                }
                if (Addition.isAddition(currentOperator)) {
                        result = Addition.add(result, queueOfNumbers.poll());
                        return;
                }
                if (Subtraction.isSubtraction(currentOperator)) {
                        result = Subtraction.subtract(result, queueOfNumbers.poll());
                        return;
                }
                if (Multiplication.isMultiplication(currentOperator)) {
                        result = Multiplication.multiple(result, queueOfNumbers.poll());
                        return;
                }
                if (Division.isDivision(currentOperator)) {
                        result = Division.divide(result, queueOfNumbers.poll());
                        return;
                }
        }

        private boolean isFirstExecution() {
                return !alreadyExecutedOperateFunction;
        }

        private int getFirstNumber() {
                return queueOfNumbers.poll();
        }
}
