package lotto;

public class Lottery {

    public static final int PRICE = 1000;
    private final int count;

    public Lottery(int money) {
        validateLotteryCount(money);
        this.count = money / PRICE;;
    }

    private void validateLotteryCount(int money) {
        checkDivision(money);
        checkIfUnderPrice(money);
    }

    private void checkDivision(int money) {
        double dividedDouble = (double) money / PRICE;
        int divideToInt = money / PRICE;
        if (divideToInt !=dividedDouble) {
            throw new IllegalArgumentException("로또 가격 단위의 구입금액을 입력해 주세요");
        }
    }

    private void checkIfUnderPrice(int money) {
        if (money < PRICE) {
            throw new IllegalArgumentException("로또 가격 보다 같거나 큰 값을 입력해 주세요.");
        }
    }

    public int getCount() {
        return count;
    }
}
