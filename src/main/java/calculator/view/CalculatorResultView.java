package calculator.view;

public class CalculatorResultView {

    public void printResultNumber(int resultNumber) {
        System.out.println("계산 결과 값은 " + resultNumber + "입니다.");
    }

    public void printInputNumberSentence() {
        System.out.println("수식을 입력하세요.(나눗셈이 정수로 떨어지게 입력해야 합니다.)");
    }
}
