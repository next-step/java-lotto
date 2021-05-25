package step3.game;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import step3.constant.Rank;
import step3.io.ConsoleInputView;
import step3.io.ConsoleResultView;
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
        List<LottoNumbers> lottoList = price.getBuyCountStream()
            .boxed()
            .map(number -> new LottoNumbers(
                RandomNumbersGenerator.createNumbers()))
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
        resultView.showText(totalLotto.toString());
    }

    private void showCount() {
        resultView.buyCount(totalLotto.size());
    }

    public void statistics() {
        try {
            LottoNumbers victoryNumber = getVictoryNumbers();
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

    private LottoNumbers getVictoryNumbers() {
        String[] numbers = inputView.getVictoryNumbers();
        Integer bonusNumber = inputView.getBonusNumber();
        validationVictoryInput(numbers);

        return new LottoNumbers(
            Arrays.stream(numbers)
                .map(number -> StringUtils.parseInt(number.trim()))
                .collect(Collectors.toList()),
            bonusNumber);
    }

    private void validationVictoryInput(String[] numbers) {
        if (numbers.length < VICTORY_SIZE) {
            throw new IllegalArgumentException(VICTORY_SIZE_CHECK);
        }
    }
}
