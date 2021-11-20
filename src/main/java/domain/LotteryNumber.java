package domain;

public class Number {
    private static final String LOTTERY_NUMBER_ERROR_MESSAGE = "error : 사용할수 있는 로또번호가 아닙니다.";
    private static final int LOTTERY_NUMBER_MIN = 1;
    private static final int LOTTERY_NUMBER_MAX = 45;
    private final int number;

    public Number(int number) {
        validLotteryNumber(number);
        this.number = number;
    }

    private void validLotteryNumber(int number){
        if(number >= LOTTERY_NUMBER_MIN && number <= LOTTERY_NUMBER_MAX){
            throw new IllegalArgumentException(LOTTERY_NUMBER_ERROR_MESSAGE);
        }
    }

    public int value() {
        return number;
    }
}
