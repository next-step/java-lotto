package lotto.domain;

public enum Rule {

    NUMBERS_OF_BALLS(6), //한 게임당 추첨할 볼의 개수
    MAX_NUMBER(45),      //볼의 최대 숫자
    MIN_NUMBER(1),       //볼의 최소 숫자
    LOTTO_PRICE(1000);   //로또당 가격

    private final int value;

    Rule(int value) {
        this.value = value;
    }

    public static boolean isNotPaymentSufficientForLotto(int payment) {
        return payment < LOTTO_PRICE.value;
    }

    public static boolean isNotInRange(int number) {
        return !(number >= MIN_NUMBER.value && number <= MAX_NUMBER.value);
    }

    public int getValue() {
        return value;
    }

}
