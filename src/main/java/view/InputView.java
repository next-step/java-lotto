package view;

public class InputView {

    public String readExpression() {
        return KeyboardInput.readInputString("공백으로 구분된 수식을 입력하세요.");
    }
}
