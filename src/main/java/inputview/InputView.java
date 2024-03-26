package inputview;

import java.util.*;

public class InputView {

    public List<List<String>> operandAndOperator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value. (ex) 2 + 3 * 4 / 5");
        String userInput = scanner.nextLine();
        List<List<String>> operandAndOperator = splitString(userInput);

        return operandAndOperator;
    }

    // 테스트용
    public List<List<String>> operandAndOperator(String userInput) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value. (ex) 2 + 3 * 4 / 5");
        if (userInput == null) {
            throw new IllegalArgumentException("문자열 계산기 입력값이 잘못되었습니다. 입력예시: 2 + 3 * 4 / 5");
        }
        List<List<String>> operandAndOperator = splitString(userInput);

        return operandAndOperator;
    }

    private boolean separateOperandAndOperator(int operandAndOperatorArrayIndex, String[] operandAndOperatorArray, List<String> operands, List<String> operators) {
        if (operandAndOperatorArrayIndex % 2 == 0) {
            operands.add(operandAndOperatorArray[operandAndOperatorArrayIndex]);
            return true;
        }

        operators.add(operandAndOperatorArray[operandAndOperatorArrayIndex]);
        return false;
    }

    private void operandsStringToInteger(List<String> operands, List<Integer> operandsTest) {
        for (String operand : operands) {
            operandsTest.add(Integer.valueOf(operand));
        }
    }

    private void checkUserInput(List<String> operands, List<String> operators) {

        if (operands.size() != (operators.size() + 1)) {
            throw new IllegalArgumentException("문자열 계산기 입력값이 잘못되었습니다. 입력예시: 2 + 3 * 4 / 5");
        }

        List<Integer> operandsTest = new ArrayList<>();
        try {
            operandsStringToInteger(operands, operandsTest);
        } catch (Exception exception) {
            throw new IllegalArgumentException("문자열 계산기 입력값이 잘못되었습니다. 입력예시: 2 + 3 * 4 / 5");
        }

        List<String> operatorsTest = new ArrayList<>(operators);
        String[] operatorStringArray = {"+", "-", "*", "/"};
        for (int i = 0; i < operatorStringArray.length; i++) {
            operatorsTest.remove(operatorStringArray[i]);
        }
        if ( !operatorsTest.isEmpty() )
        {
            throw new IllegalArgumentException("문자열 계산기 입력값이 잘못되었습니다. 입력예시: 2 + 3 * 4 / 5");
        }
    }

    private List<List<String>> splitString(String userInput) {
        List<List<String>> operandAndOperator = new ArrayList<>();
        List<String> operands = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        String[] operandAndOperatorArray = userInput.split(" ");

        for (int i = 0; i < operandAndOperatorArray.length; i++) {
            separateOperandAndOperator(i, operandAndOperatorArray, operands, operators);
        }

        checkUserInput(operands, operators);

        operandAndOperator.add(0, operands);
        operandAndOperator.add(1, operators);

        return operandAndOperator;
    }

}
