package step3.game;

import java.util.Map;

import step3.constant.Rank;
import step3.io.ConsoleInputView;
import step3.io.ConsoleResultView;
import step3.model.LottoNumber;
import step3.model.LottoNumbers;
import step3.model.Price;
import step3.model.RandomNumbersGenerator;
import step3.model.TotalLotto;
import step3.util.StringUtils;

public class Lotto {

    private static final int VICTORY_SIZE = 6;
    private static final String VICTORY_SIZE_CHECK = "6개의 숫자를 입력하세요";

    private ConsoleInputView inputView;
    private ConsoleResultView resultView;
    private TotalLotto totalLotto;
    private Price price;

    public Lotto() {
        this.inputView = new ConsoleInputView();
        this.resultView = new ConsoleResultView();
    }

    public TotalLotto pickLottoWithPrice(Price price) {
        TotalLotto totalLotto = new TotalLotto();
        int totalCount = price.getBuyCount();
        for (int index = 0; index < totalCount; index++) {
            totalLotto.addLottoOne(RandomNumbersGenerator.createNumbers());
        }
        return totalLotto;
    }

    public void start() {
        buy();
        statistics();
    }

    private void buy() {
        try {
            price = new Price(inputView.getPrice());
            totalLotto = pickLottoWithPrice(price);
            showLotto();
            resultView.showEmptyLine();
        } catch (Exception e) {
            resultView.showText(e.getMessage());
            buy();
        }

    }

    private void showLotto() {
        showCount();
        showTotalLotto();
    }

    private void showTotalLotto() {
        resultView.showTotalLotto(totalLotto.lotto());
    }

    private void showCount() {
        resultView.buyCount(totalLotto.size());
    }

    public void statistics() {
        try {
            resultView.showInputVictoryNumber();
            LottoNumbers victoryNumber = getVictoryNumbers(inputView.getVictoryNumbers());
            showWinning(totalLotto.groupByWinnerPrice(victoryNumber));
            showBanefit(totalLotto.getBenefit(victoryNumber, price));

        } catch (Exception e) {
            resultView.showText(e.getMessage());
            statistics();
        }

    }

    private void showBanefit(String benefit) {
        resultView.showBenefit(benefit);
    }

    private void showWinning(Map<Rank, Long> map) {
        resultView.showWinning(map);
    }

    private LottoNumbers getVictoryNumbers(String victoryNumbers) {
        LottoNumbers result = new LottoNumbers();
        String[] numbers = victoryNumbers.split(",");
        for (String number : numbers) {
            number = number.trim();
            result.addNumber(new LottoNumber(StringUtils.parseInt(number)));
        }
        validationVictoryInput(result);

        return result;
    }

    private void validationVictoryInput(LottoNumbers result) {
        if (result.size() < VICTORY_SIZE) {
            throw new IllegalArgumentException(VICTORY_SIZE_CHECK);
        }
    }
}
