package calculator.service;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    static Queue<Integer> numbers = new LinkedList<>();
    static Queue<String> operations = new LinkedList<>();

    public static int calculate(String input) {
        String[] splitInput = input.split(" ");
        setNumbers(splitInput);
        setOperations(splitInput);

        return calculateProcess(numbers.poll());
    }

    public static int calculateProcess(int initNum){
        int num = numbers.poll();
        String operation = operations.poll();

        if(operation.equals("+")) {
            initNum += num;
        }
        if(operation.equals("-")) {
            initNum -= num;
        }
        if(operation.equals("*")) {
            initNum *= num;
        }

        if(operation.equals("/")) {
            checkDivide(initNum, num);
            initNum = (int)(initNum / num);
        }

        if(numbers.size() > 0) {
            initNum = calculateProcess(initNum);
        }
        return initNum;
    }

    private static void checkDivide(int initNum, int num) {
        if(initNum % num > 0){
            throw new InvalidParameterException();
        }
    }

    private static void setNumbers(String[] inputs){
        for (int i = 0; i < inputs.length; i+=2) {
            numbers.add(parseInt(inputs[i]));
        }
    }

    private static void setOperations(String[] inputs){
        for (int i = 1; i < inputs.length; i+=2) {
            operations.add(inputs[i]);
        }
    }
    private static int parseInt(String input){
        return Integer.parseInt(input);
    }
}
