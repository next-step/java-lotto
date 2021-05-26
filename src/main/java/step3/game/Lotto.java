package step3.game;

import java.util.List;
import java.util.stream.Collectors;

import step3.io.ConsoleInputView;
import step3.io.ConsoleResultView;
import step3.model.LottoNumbers;
import step3.model.Price;
import step3.model.RandomNumbersGenerator;
import step3.model.TotalLotto;

public class Lotto {

    private ConsoleInputView inputView;
    private ConsoleResultView resultView;
    private TotalLotto totalLotto;
    private Price price;

    public Lotto() {
        this.inputView = new ConsoleInputView();
        this.resultView = new ConsoleResultView();
    }

    public TotalLotto pickLottoWithPrice(Price price) {
        List<LottoNumbers> lottoList = price.getBuyCountStream()
            .boxed()
            .map(number -> LottoNumbers
                .of(RandomNumbersGenerator.createNumbers()))
            .collect(Collectors.toList());

        return new TotalLotto(lottoList);
    }

    public void start() {
        buy();
        statistics();
    }

    private void buy() {
        try {
            price = new Price(inputView.getPrice());
            totalLotto = pickLottoWithPrice(price);
            resultView.buyCount(totalLotto);
            resultView.showTextStatus(totalLotto);
            resultView.showEmptyLine();
        } catch (IllegalArgumentException e) {
            resultView.showText(e.getMessage());
            buy();
        }

    }

    public void statistics() {
        try {
            LottoNumbers victoryNumber = getVictoryNumbers();
            resultView
                .showWinning((totalLotto.groupByWinnerPrice(victoryNumber)));
            resultView
                .showBenefit(totalLotto.getBenefit(victoryNumber, price));

        } catch (IllegalArgumentException e) {
            resultView.showText(e.getMessage());
            statistics();
        }

    }

    private LottoNumbers getVictoryNumbers() {
        return LottoNumbers.of(inputView.getVictoryNumbers(),
            inputView.getBonusNumber());
    }

}
