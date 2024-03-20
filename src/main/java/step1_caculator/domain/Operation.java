package step1_caculator.domain;

public class Operation {
    private int resultNumber;
    public Operation() {
        this.resultNumber = 0;
    }

    public Operation(int resultNumber) {
        this.resultNumber = resultNumber;
    }

    public int getResult() {
        return resultNumber;
    }

    public void setResult(int result) {
        this.resultNumber = result;
    }

    public int plus(int number) {
        return this.resultNumber += number;
    }

    public int minus(int number) {
        return this.resultNumber -= number;
    }

    public int divide(int number) {
        return this.resultNumber /= number;
    }

    public int multiple(int number) {
        return this.resultNumber *= number;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "result=" + resultNumber +
                '}';
    }
}
