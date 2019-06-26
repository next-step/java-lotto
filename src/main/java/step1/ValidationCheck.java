package step1;

public class ValidationCheck {

    public int inputNumberCheckIsEmpty(String inputNumbers) {
        if (inputNumbers == null) {
            return 0;
        }
        if (inputNumbers.isEmpty()) {
            return 0;
        }
        return 1;
    }

    public void checkNegative(int inputNumbers) {
        if(inputNumbers < 0){
            throw new IllegalArgumentException("음수를 포함한 덧셈은 불가합니다.");
        }
    }
}
