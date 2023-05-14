package lotto.step1.domain;

import lotto.step1.enums.Operator;

import java.util.Optional;

public class Calculator {
    private final Input calcList;
    private final NumberQueue numberQueue;
    private final MathOpQueue mathOperationQueue;


    public Calculator(Input calcList, NumberQueue numberQueue, MathOpQueue mathOperationQueue) {
        this.calcList = calcList;
        this.numberQueue = numberQueue;
        this.mathOperationQueue = mathOperationQueue;
    }

    public int getResult() {
        setNumberAndOperation();

        while (!mathOperationQueue.isEmpty()) {
            int a = Optional.ofNullable(numberQueue.poll()).orElse(0);
            int b = Optional.ofNullable(numberQueue.poll()).orElse(0);
            String symbol = mathOperationQueue.poll();
            MathOperation mathOperation = getMathOperation(symbol);

            numberQueue.addFirst(mathOperation.calc(a, b));
        }

        return Optional.ofNullable(numberQueue.poll()).orElse(0);
    }

    private void setNumberAndOperation() {
        numberQueue.analyzeNumber(calcList);
        mathOperationQueue.analyzeOperation(calcList);
        checkValidation();
    }

    public void checkValidation() {
        int numberQueueSize = numberQueue.getSize() - 1;
        int mathQueueSize = mathOperationQueue.getSize();

        if (numberQueueSize != mathQueueSize) {
            throw new IllegalArgumentException("피연산자 -1 은 연산자 개수와 같아야합니다.(피연산자-1: " + numberQueueSize + ", 연산자: " + mathQueueSize);
        }
    }

    private MathOperation getMathOperation(String symbol) {
        return Operator.execute(symbol);
    }


}
