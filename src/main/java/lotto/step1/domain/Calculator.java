package lotto.step1.domain;

import java.util.*;

public class Calculator {
    private final List<String> calcList;
    private final Deque<Integer> numberQueue = new ArrayDeque<>();
    private final Deque<String> mathOperationQueue = new ArrayDeque<>();


    public Calculator(List<String> calcList) {
        checkValidation(calcList);
        this.calcList = calcList;
    }

    private void checkValidation(List<String> calcList) {
        if (calcList.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
        calcList.forEach(s -> {
            if (s.isBlank()) {
                throw new IllegalArgumentException("입력값은 공백일 수 없습니다.");
            }
        });
    }

    private void checkValidation(Deque<Integer> numberQueue, Deque<String> mathOperationQueue) {
        int numberQueueSize = numberQueue.size() - 1;
        int mathQueueSize = mathOperationQueue.size();

        if (numberQueueSize != mathQueueSize) {
            throw new IllegalArgumentException("피연산자 -1 은 연산자 개수와 같아야합니다.(피연산자-1: " + numberQueueSize + ", 연산자: " + mathQueueSize);
        }
    }

    public int getResult() {
        analyzeNumberAndOperation();

        while (!mathOperationQueue.isEmpty()) {
            int a = Optional.ofNullable(numberQueue.poll()).orElse(0);
            int b = Optional.ofNullable(numberQueue.poll()).orElse(0);
            String operation = mathOperationQueue.poll();
            MathOperation mathOperation = getMathOperation(operation);

            numberQueue.addFirst(mathOperation.calc(a, b));
        }

        return Optional.ofNullable(numberQueue.poll()).orElse(0);
    }

    private MathOperation getMathOperation(String operation) {
        switch (operation) {
            case "+":
                return new Addition();
            case "-":
                return new Subtraction();
            case "*":
                return new Multiplication();
            case "/":
                return new Division();
            default:
                throw new IllegalArgumentException("유효하지 않은 연산자 '" + operation + "'를 사용하셨습니다.");
        }
    }

    private void analyzeNumberAndOperation() {
        calcList.forEach(e -> {
            if (isDigit(e)) {
                numberQueue.add(Integer.parseInt(e));
            }
            if (!isDigit(e)) {
                mathOperationQueue.add(e);
            }
        });
        checkValidation(numberQueue, mathOperationQueue);
    }

    private boolean isDigit(String e) {
        return Character.isDigit(e.charAt(0));
    }
}
