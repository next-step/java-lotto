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

    public Lottos buyManualLottos(String[] manualNumbers){
        decreaseAmount(manualNumbers.length);
        if(purchaseAmount < 0){
            throw new IllegalArgumentException("로또를 구매할 돈이 부족합니다");
        }
        return new Lottos(manualNumbers);
    }

    public Lottos buyAutoLottos(LottoNumbersGenerater generator) {
        int lottoCount = purchaseAmount / PRICE;
        decreaseAmount(lottoCount);
        return Lottos.create(lottoCount, generator);
    }

    private void decreaseAmount(int lottoCount){
        this.purchaseAmount -= (lottoCount * PRICE);
    }


}
