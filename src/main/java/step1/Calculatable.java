package step1;

public interface Calculatable {
    abstract int calculate(String value);

    default int inNegative(int num) {
        if (num < 0) {
            throw new RuntimeException("음수입니다.");
        }

        return num;
    }


}
