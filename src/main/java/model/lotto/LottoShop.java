package model.lotto;

import generator.NumberGenerator;
import ui.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {
    private static final int LOTTO_PER_AMOUNT = 1000;
    private final NumberGenerator numberGenerator;

    public LottoShop(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Lottos generateLotto (Price price) {
        int totalCounts = changePriceToLottoCount(price);
        int manualCounts = InputView.getManualLottoCount();
        LottoCount lottoCount = new LottoCount(totalCounts, manualCounts);

        List<Lotto> manualLottos = InputView.getManualLottoList(lottoCount.getManualLottoCount());
        List<Lotto> autoLottos = new ArrayList<>();
        for (int index = 0; index < lottoCount.getAutoLottoCount(); index++) {
            autoLottos.add(new Lotto(numberGenerator.generate()));
        }

        return new Lottos(manualLottos, autoLottos);
    }

    private int changePriceToLottoCount(Price price) {
        validLottoPayAmount(price);
        return price.getPrice() / LOTTO_PER_AMOUNT;
    }

    private void validLottoPayAmount(Price price){
        if(price.getPrice() < LOTTO_PER_AMOUNT) {
            throw new IllegalArgumentException("최소 구매 가능 금액은 천원입니다.");
        }
    }

}
