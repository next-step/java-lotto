package lotto.domain;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class LottoMachine {
    private static final int PRICE = 1000;

    private int purchaseAmount;

    public LottoMachine(int purchaseAmount) {
        if(purchaseAmount < PRICE){
            throw new IllegalArgumentException("로또 구매를 위해서 최소 1000원 이상의 금액이 필요합니다");
        }
        this.purchaseAmount = purchaseAmount;
    }

    public Lottos buyManualLottos(List<String> manualNumbers){
        decreaseAmount(manualNumbers.size());
        if(purchaseAmount < 0){
            throw new IllegalArgumentException("로또를 구매할 돈이 부족합니다");
        }
        List<Lotto> lottos = convertStringToLotto(manualNumbers);
        return new Lottos(lottos);
    }

    public Lottos buyAutoLottos(LottoNumbersGenerater generator) {
        int lottoCount = purchaseAmount / PRICE;
        decreaseAmount(lottoCount);
        return Lottos.create(lottoCount, generator);
    }

    private void decreaseAmount(int lottoCount){
        this.purchaseAmount -= (lottoCount * PRICE);
    }

    private List<Lotto> convertStringToLotto(List<String> manualNumbers){
        return manualNumbers.stream()
                .map(Lotto::new)
                .collect(toList());
    }


}
