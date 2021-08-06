package lottery.domain;

import lottery.dto.LotteryNumberDto;

import java.util.Objects;

public class LotteryNumber {

    public static final String INVALID_NUMBER = "유효하지 않은 로또 숫자 입니다 -> ";
    public static final int MIN = 1;
    public static final int MAX = 45;

    private final int lotteryNumber;

    public LotteryNumber(final int lotteryNumber) {
        validateLotteryNumber(lotteryNumber);
        this.lotteryNumber = lotteryNumber;
    }

    public LotteryNumberDto toDto() {
        return new LotteryNumberDto(lotteryNumber);
    }

    private void validateLotteryNumber(final int lotteryNumber) {
        if (lotteryNumber < MIN || lotteryNumber > MAX) {
            throw new IllegalArgumentException(INVALID_NUMBER + lotteryNumber);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryNumber that = (LotteryNumber) o;
        return lotteryNumber == that.lotteryNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteryNumber);
    }
}
