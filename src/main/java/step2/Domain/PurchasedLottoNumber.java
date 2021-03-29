package step2.Domain;

public class PurchasedLottoNumber {

    private int number;

    public PurchasedLottoNumber(Money money){
        this.number = money.getMoney() / Money.DEFAULT_LOTTO_PRICE;
    }

    public int getNumber(){
        return number;
    }
}
