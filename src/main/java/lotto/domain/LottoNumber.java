package lotto.domain;

public class LottoNumber {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private int[] lottoNumber;

    private LottoNumber(int[] lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of() {
        int[] numbers = new int[6];
        for (int i = 0; i < 6; i++) {
            numbers[i] = ShuffleNumber.shuffle(START_NUMBER, END_NUMBER).get(i);
        }
        return new LottoNumber(numbers);
    }

}
