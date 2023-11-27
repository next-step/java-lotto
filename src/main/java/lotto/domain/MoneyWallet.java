package lotto.domain;

public class MoneyWallet {

    private static final int DEFAULT_AMOUNT = 0;

    private final int balance;

    public MoneyWallet() {
        this(DEFAULT_AMOUNT);
    }

    public MoneyWallet(int amount) {
        this.balance = amount;
    }

    public MoneyWallet deposit(int amount) {
        return new MoneyWallet(this.balance + amount);
    }

    public MoneyWallet withdraw(int amount) {
        withdrawValidate(amount);
        return new MoneyWallet(this.balance - amount);
    }

    private void withdrawValidate(int amount) {
        if(amount > this.balance){
            throw new IllegalArgumentException("지갑 잔액이 부족합니다.");
        }
    }

    public int balance(){
        return balance;
    }
}
