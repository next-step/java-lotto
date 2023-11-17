package lotto;

public class LottoNumber {
    private final int number;

    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 45;

    public LottoNumber(int number) {
        validation(number);
        this.number = number;
    }

    private void validation(int number) {
        if(number < MIN_NUMBER){
            throw new IllegalArgumentException("로또의 숫자는 최소 1입니다.");
        }
        if(number > MAX_NUMBER){
            throw new IllegalArgumentException("로또의 숫자는 최대 45입니다.");
        }
    }

    public static LottoNumber from(int number){
        return new LottoNumber(number);
    }

    public boolean compare(int compareInteger) {
        return this.number == compareInteger;
    }
}
