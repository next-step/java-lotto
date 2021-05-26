package study.ascii92der.lotto.step3;

public class LottoPrice {

    public static final int LOTTO_PRICE = 1000;
    public static final String ERROR_MASSAGE_NEGATIVE_INPUT_MONEY = "input money is negative";
    private final int money;

    public LottoPrice(int money) {
        if(money<0){
            throw new IllegalArgumentException(ERROR_MASSAGE_NEGATIVE_INPUT_MONEY);
        }
        this.money = money;
    }

    public int lottoCount() {
        return money / LOTTO_PRICE;
    }
}
