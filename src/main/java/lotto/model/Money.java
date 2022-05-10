package lotto.model;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private final int value;

    public Money() {
        this(0);
    }

    public Money(int money) {
        validate(money);
        this.value = money;
    }

    public int getValue() {
        return value;
    }

    public Money add(Money money) {
        return new Money(this.value + money.value);
    }

    public Money multiply(int count) {
        return new Money(this.value * count);
    }

    public double divide(Money money) {
        if(money.getValue() == 0L) {
            throw new ArithmeticException("0으로 나눌 수 없습니다");
        }
        return (double) this.value / money.value;
    }

    public int calculateTicketCnt(){
        if(value % LOTTO_PRICE != 0){
            throw new IllegalArgumentException("구입금액은 1000의 배수여야합니다.");
        }
        return this.value / LOTTO_PRICE;
    }


    private void validate(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("돈은 음수값을 가질 수 없습니다.");
        }
    }


    @Override
    public String toString(){
        return value+"";
    }


}
