package model;

public class LottoNumber {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final String LOTTO_BOUND_ERORR_MESSAGE = MIN_NUM + "에서 " + MAX_NUM + "까지 범위가 아닙니다.";
    private int number;

    public LottoNumber(int number) {
        isValidLottoRange(number);

        this.number = number;
    }

    public int getLottoNumber() {
        return this.number;
    }

    private static void isValidLottoRange(int number) {
        boolean isValidRange = number >= MIN_NUM && number <= MAX_NUM;

        if (!isValidRange) {
            throw new RuntimeException(LOTTO_BOUND_ERORR_MESSAGE);
        }
    }

}
