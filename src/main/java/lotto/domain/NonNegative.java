package lotto.domain;

public class NonNegative {

    private final int number;

    public NonNegative(int number) {
        if(number <= 0){
            throw new IllegalArgumentException("숫자가 0이상이어야 합니다.");
        }
        this.number = number;
    }


    public boolean isLessThan(NonNegative nonNegative){
        return this.number < nonNegative.number;
    }


    public int minus(NonNegative nonNegative) {
        return this.number - nonNegative.number;
    }

    public int getNumber() {
        return this.number;
    }
}
