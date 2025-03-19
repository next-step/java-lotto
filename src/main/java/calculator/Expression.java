package calculator;

public class Expression {

    public void parse(String input) {
        if(isEmpty(input)) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }
        // TODO 구현
    }

    private boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

}
