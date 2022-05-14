package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class NumberSentence {

    private final List<Integer> numberList = new ArrayList<>();
    private final List<Character> operationList = new ArrayList<>();

    public NumberSentence(String sentence) {
        if (sentence == null || sentence.isBlank()) {
            throw new IllegalArgumentException("입력 값은 빈 공백문자일 수 없습니다.");
        }
        splitNumberAndOperation(sentence.split(" "));
    }

    private void splitNumberAndOperation(String[] elementList) {
        validNumberOfElement(elementList);
        for (int position = 0; position < elementList.length; position++) {
            addNumber(position, elementList[position]);
            addOperator(position, elementList[position]);
        }
    }

    private void addNumber(int position, String element) {
        if (isNumberPosition(position)) {
            numberList.add(Integer.parseInt(element));
        }
    }

    private void addOperator(int position, String element) {
        if (isOperatorPosition(position)) {
            validOperator(element);
            operationList.add(element.charAt(0));
        }
    }

    private boolean isNumberPosition(int index) {
        return index % 2 == 0;
    }

    private boolean isOperatorPosition(int index) {
        return index % 2 != 0;
    }

    private void validNumberOfElement(String[] element) {
        if (element.length % 2 == 0) {
            throw new IllegalArgumentException("수식의 요소는 짝수일 수 없습니다.");
        }
    }

    private void validOperator(String operator) {
        if (operator.length() != 1) {
            throw new IllegalArgumentException("연산자는 사칙연산(+,-,/,*) 기호 중에 입력해야 합니다.");
        }

        char op = operator.charAt(0);
        if (op != '+' && op != '-' && op != '/' && op != '*') {
            throw new IllegalArgumentException("연산자는 사칙연산(+,-,/,*) 기호 중에 입력해야 합니다.");
        }
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    public List<Character> getOperationList() {
        return operationList;
    }

}
