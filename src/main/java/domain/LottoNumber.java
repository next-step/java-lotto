package domain;

public class LottoNumber {
    public final static int MIN_RANGE = 1;
    public final static int MAX_RANGE = 45;

    private final int number;


    public LottoNumber(int number){
        this.validate(number);
        this.number = number;
    }

    private void validate(int number){
        if(number < MIN_RANGE || number > MAX_RANGE){
            throw new IllegalArgumentException("Lotto number의 범위를 넘어섰습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }
}
