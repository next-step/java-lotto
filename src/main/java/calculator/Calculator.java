package calculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Calculator {

        private Queue<Integer> queueOfNumbers = new LinkedList<>();
        private Queue<Operator> queueOfOperators = new LinkedList<>();

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
                queueOfOperators.add(Operator.valueOfCode(text));
        }

        private void operate() {
                Operator currentOperator = (queueOfOperators.poll());
                if (isFirstExecution()) {
                        result = getFirstNumber();
                        alreadyExecutedOperateFunction = true;
                }
                result = currentOperator.apply(result, queueOfNumbers.poll());
        }

        private boolean isFirstExecution() {
                return !alreadyExecutedOperateFunction;
        }

        private int getFirstNumber() {
                return queueOfNumbers.poll();
        }
}
