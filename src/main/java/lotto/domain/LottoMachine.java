package lotto.domain;

public class LottoMachine {
    private static final int PRICE = 1000;

    private int purchaseAmount;

    public LottoMachine(int purchaseAmount) {
        if(purchaseAmount < PRICE){
            throw new IllegalArgumentException("로또 구매를 위해서 최소 1000원 이상의 금액이 필요합니다");
        }
        this.purchaseAmount = purchaseAmount;
    }

    public Lottos buyAutoLottos(LottoNumbersGenerater generator) {
        int lottoCount = purchaseAmount / PRICE;
        return Lottos.create(lottoCount, generator);
    }
}
