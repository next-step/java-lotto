package lotto.step1.domain;

import java.util.*;

public class Calculator {
    private final List<String> calcList;
    private final Deque<Integer> numberQueue = new ArrayDeque<>();
    private final Deque<String> mathOperationQueue = new ArrayDeque<>();


    public Calculator(List<String> calcList) {
        if (calcList.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
        this.calcList = calcList;
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
    }

    private boolean isDigit(String e) {
        return Character.isDigit(e.charAt(0));
    }

    public static void main(String[] args) {
        String[] data = "2 + 3 * 4 / 2".split(" ");
        String[] b = " ".split(" ");
        List<String> a = Arrays.asList(b);
        Calculator c = new Calculator(a);
        System.out.println(c.getResult());

    }
}
