package calculator.domain;

public class CurrentResult {
    private int currentResult;

    CurrentResult(int initialValue) {
        this.currentResult = initialValue;
    }

    public int getCurrentResult() {
        return currentResult;
    }

    void updateResult(int currentResult) {
        this.currentResult = currentResult;
    }
}
