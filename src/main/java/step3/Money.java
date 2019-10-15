package step3;

public class Money {

    private static final int LOTTO_PRICE = 1000;
    private static int inputCash;

    public Money(int inputCash) {
        validateMoney(inputCash);
        this.inputCash = inputCash / LOTTO_PRICE;
    }

    public int getLottoCount(){
        return this.inputCash;
    }

    public int getInputCash(){
        return this.inputCash * LOTTO_PRICE;
    }

    private static void validateMoney(int inputCash) {
        if (inputCash < LOTTO_PRICE)
            throw new IllegalArgumentException("로또는 1장에 " + LOTTO_PRICE + " 원 입니다.");
    }


}
