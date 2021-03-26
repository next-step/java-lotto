package step2;

public class PurchasedLottoNumber {

    private static final int DEFAULT_LOTTO_PRICE = 1000;
    private int number;

    public PurchasedLottoNumber(Money money){
        this.number = money.getMoney() / DEFAULT_LOTTO_PRICE;
    }

    public int getNumber(){
        return number;
    }
}
