package lottery.domain;

import lottery.dto.LotteryNumberDto;

import java.util.Objects;
import java.util.regex.Pattern;

public class LotteryNumber {

    private static final String NON_NULL = "입력값은 null 일 수 없습니다";
    private static final String NOT_NUMBER = "숫자가 아닙니다 -> ";
    private static final String INVALID_NUMBER = "유효하지 않은 로또 숫자 입니다 -> ";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");
    public static final int MIN = 1;
    public static final int MAX = 45;

    private final int lotteryNumber;

    public LotteryNumber(final int lotteryNumber) {
        requireLotteryNumber(lotteryNumber);
        this.lotteryNumber = lotteryNumber;
    }

    public LotteryNumber(final String lotteryNumber) {
        validateLotteryNumber(lotteryNumber);
        this.lotteryNumber = Integer.parseInt(lotteryNumber);
    }

    public LotteryNumberDto toDto() {
        return new LotteryNumberDto(lotteryNumber);
    }

    private void validateLotteryNumber(final String lotteryNumber) {
        requireNonNull(lotteryNumber);
        requireNumber(lotteryNumber);
        requireLotteryNumber(Integer.parseInt(lotteryNumber));
    }

    private void requireLotteryNumber(final int lotteryNumber) {
        if (lotteryNumber < MIN || lotteryNumber > MAX) {
            throw new IllegalArgumentException(INVALID_NUMBER + lotteryNumber);
        }
    }

    private void requireNumber(String number) {
        if (!NUMBER_PATTERN.matcher(number).matches()) {
            throw new IllegalArgumentException(NOT_NUMBER + number);
        }
    }

    private void requireNonNull(final String lotteryNumbers) {
        if (Objects.isNull(lotteryNumbers)) {
            throw new IllegalArgumentException(NON_NULL);
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
