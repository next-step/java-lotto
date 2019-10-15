package step3;

public class Money {
    // TODO: LOTTO_PRICE의 사용범위 체크해서, private 지정해놓기
    private static final int LOTTO_PRICE = 1000;
    private static int inputCash;

    public Money(int inputCash) {
        validateMoney(inputCash);
        this.inputCash = inputCash / LOTTO_PRICE;
    }

    private static void validateMoney(int inputCash) {
        if (inputCash < Lotto.LOTTO_PRICE)
            throw new IllegalArgumentException("로또는 1장에 " + Lotto.LOTTO_PRICE + " 원 입니다.");
    }


}
