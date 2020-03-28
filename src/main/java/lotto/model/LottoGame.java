package lotto.model;

import lotto.lottogenerator.LottoNumGeneratorStrategy;
import lotto.view.InputView;
import lotto.view.StringConverter;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private int lottoCount;
    private List<Lotto> lottos = new ArrayList<>();

    public LottoGame(InputView inputView) {
        Money money = StringConverter.convertStringToMoney(inputView);
        lottoCount = money.findLottoCountToBuy();
    }

    public void start(LottoNumGeneratorStrategy lottoNumGeneratorStrategy) {
        lottos.add(new Lotto(lottoNumGeneratorStrategy.generate()));
        lottoCount--;
    }

    public boolean isEnd() {
        return lottoCount == 0;
    }

    public Lottos getLottos() {
        return new Lottos(lottos);
    }
}