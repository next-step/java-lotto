package study.calculator;

import study.enums.Operation;

public class SentenceCalculator {

    int opreationResult = 0;

    String inputSentence = null;

    String separation = " ";
    String plus = "+";
    String minus = "-";
    String multiply = "*";
    String division = "/";


    public SentenceCalculator(String sentence) {
        isValidSentence(sentence);
        this.inputSentence = sentence;
    }


    public int doCalculate() {
        String[] values = inputSentence.split(separation);

        opreationResult = toNumber(values[0]);

        for (int i = 1; i < values.length; i++) {
            opreationResult = addOperation(values[i], values[++i]);
        }


        return opreationResult;
    }


    private int addOperation(String operationText, String rightValue) {
        int rightNum = toNumber(rightValue);

        Operation operation = Operation.findBy(operationText);
        return operation.calculate(opreationResult, rightNum);
    }


    private void isValidSentence(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 연산입니다");
        }

        if (!sentence.contains(separation)) {
            throw new IllegalArgumentException("연산은 반드시 빈 공백 문자열을 포함해야 합니다");
        }

        if (sentence.split(separation).length < 3) {
            throw new IllegalArgumentException("완전하지 않은 연산입니다");
        }
    }


    private int toNumber(String textNum) {
        if (textNum == null || textNum.trim() == "") {
            throw new IllegalArgumentException("입력한 값이 유효하지 않습니다");
        }
        return Integer.parseInt(textNum);
    }

}
