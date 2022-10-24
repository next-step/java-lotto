package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Calculator {

    private final InputView inputView;
    private final OutputView outputView;

    public Calculator(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start(){
        startCalculate(inputView.scanStringResult());
    }

    public void startCalculate(String input) {
        outputView.printResult(calculate(parseString(input)));
    }

    private int calculate(Queue<String> parsedQueue) {
        int result = Integer.parseInt(parsedQueue.poll());

        while (!parsedQueue.isEmpty()) {
            int first = result;
            String operator = parsedQueue.poll();
            int second = Integer.parseInt(parsedQueue.poll());
            int operated = operate(first, operator, second);
            result = operated;
        }
        return result;
    }

    private int operate(int first, String operator, int second) {
        if (operator == "+"){
            return first + second;
        }
        if (operator == "-"){
            return first - second;
        }
        if (operator == "*"){
            return first * second;
        }
        else {
            if(second == 0) {
                throw new IllegalArgumentException("나눗셈 분모에 0이 올 수 없습니다.");
            }
            return first / second;
        }
    }

    private static Queue parseString(String input) {

        if (input == null || input.equals("")) {
            throw new IllegalArgumentException("공백값이 올 수 없습니다");
        }

        String[] strings = input.split(" ");

        Queue<String> queue = new LinkedList<>();
        Arrays.stream(strings).forEach(string -> queue.add(string));
        return queue;
    }
}
