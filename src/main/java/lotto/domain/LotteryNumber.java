package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LotteryNumber {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static Map<Integer, LotteryNumber> lottoNumbers = new HashMap<>();

    private final int number;

    static {
        for (int i = START_NUMBER; i <= END_NUMBER; i++) {
            lottoNumbers.put(i, new LotteryNumber(i));
        }
    }

    private LotteryNumber(int number) {
        this.number = number;
    }

    public static LotteryNumber of(String number) {
        return of(Integer.valueOf(number));
    }

    public static LotteryNumber of(int number) {
        LotteryNumber lotteryNumber = lottoNumbers.get(number);
        if (lotteryNumber == null) {
            throw new IllegalArgumentException("로또 당첨 번호는 " + START_NUMBER + " 이상 " + END_NUMBER + " 이하의 수 입니다.");
        }
        return lotteryNumber;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryNumber that = (LotteryNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
