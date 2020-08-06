package camp.nextstep.edu.rebellion.lotto.domain.ticket;

public class LottoNumber {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private final int number;

    public LottoNumber(int number) {
        checkRange(number);
        this.number = number;
    }

    public boolean equals(LottoNumber number) {
        return this.number == number.getNumber();
    }

    public int getNumber() {
        return number;
    }

    private int checkRange(int number) {
        if(LOTTO_MIN_NUMBER > number || LOTTO_MAX_NUMBER < number) {
            throw new IllegalArgumentException("당첨번호가 잘못되었습니다 " + number);
        }
        return number;
    }
}
