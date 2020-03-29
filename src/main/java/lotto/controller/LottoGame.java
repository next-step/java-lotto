package lotto.controller;

import lotto.lottogenerator.LottoNumGeneratorStrategy;
import lotto.model.LottoNumbers;
import lotto.model.MyLottos;
import lotto.model.Money;
import lotto.view.InputView;
import lotto.view.StringConverter;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int COUNT_TO_STOP = 0;

    private int lottoCount;
    private List<LottoNumbers> lottoNumbers = new ArrayList<>();

    public LottoGame(InputView inputView) {
        Money money = StringConverter.convertStringToMoney(inputView.getInput());
        lottoCount = money.findLottoCountToBuy();
    }

    public void start(LottoNumGeneratorStrategy lottoNumGeneratorStrategy) {
        lottoNumbers.add(new LottoNumbers(lottoNumGeneratorStrategy.generate()));
        lottoCount--;
        while (!isEnd()) {
            start(lottoNumGeneratorStrategy);
        }
    }

    public boolean isEnd() {
        return lottoCount == COUNT_TO_STOP;
    }

    public MyLottos getMyLottos() {
        return new MyLottos(lottoNumbers);
    }

    public int findHowManyMyLottos(){
        return lottoNumbers.size();
    }
}