package lotto.domain;

public class Positive extends NonNegative{

    public Positive(int number) {
        super(number);
        if(number == 0){
            throw new IllegalArgumentException("숫자가 0보다 커야 합니다.");
        }
    }

}
