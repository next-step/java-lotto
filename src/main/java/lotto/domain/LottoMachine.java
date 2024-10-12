package lotto.domain;

public class LottoMachine {
    private final int PRICE = 1000;

    public int buyLottos(int purchaseAmount) {
        if(purchaseAmount <= 0){
            throw new IllegalArgumentException("로또를 구매할 수 없습니다");
        }
        return purchaseAmount / PRICE;
    }
}
