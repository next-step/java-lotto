package lottery.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class Money implements Comparable<Money> {

    public static final String NON_NULL = "입력값은 null 일 수 없습니다";
    public static final String NOT_NUMBER = "숫자가 아닙니다 -> ";
    public static final String LESS_THAN_ZERO = "입력값은 0 보다 커야 합니다 -> ";
    public static final String NOT_ENOUGH_MONEY = "로또를 구매하기에 돈이 부족합니다 (로또 가격: " + Lottery.PRICE + ") -> ";
    private static final int ZERO = 0;
    private static Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");

    private final int money;

    public Money(final String money) {
        validateMoney(money);
        this.money = Integer.parseInt(money);
    }

    public Money(final int money) {
        requirePositiveNumber(money);
        this.money = money;
    }

    public int getBuyableLotteryCount() {
        requireOverLotteryPrice();
        return money / Lottery.PRICE.money;
    }

    public long multiply(long number) {
        return money * number;
    }

    public double divide(long number) {
        return (double) this.money / number;
    }

    private void validateMoney(final String money) {
        requireNonNull(money);
        requireNumber(money);
        requirePositiveNumber(Integer.parseInt(money));
    }

    private void requirePositiveNumber(final int money) {
        if (money < ZERO) {
            throw new IllegalArgumentException(LESS_THAN_ZERO + money);
        }
    }

    private void requireOverLotteryPrice() {
        if (money < Lottery.PRICE.money) {
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY + money);
        }
    }

    private void requireNumber(String number) {
        if (!NUMBER_PATTERN.matcher(number).matches()) {
            throw new IllegalArgumentException(NOT_NUMBER + number);
        }
    }

    private void requireNonNull(final String money) {
        if (Objects.isNull(money)) {
            throw new IllegalArgumentException(NON_NULL);
        }
    }

    @Override
    public int compareTo(final Money money) {
        return this.money - money.money;
    }

    @Override
    public String toString() {
        return String.valueOf(money);
    }
}
