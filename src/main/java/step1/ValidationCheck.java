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

}
