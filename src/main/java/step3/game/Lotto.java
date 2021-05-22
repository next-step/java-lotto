package step3.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import step3.io.InputView;
import step3.io.ResultView;
import step3.model.LottoNumber;
import step3.model.LottoNumbers;
import step3.model.Price;
import step3.model.TotalLotto;

public class Lotto {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String ONLY_NUMBER = "숫자를 입력하세요";
    private static final int VICTORY_SIZE = 6;
    private static final String VICTORY_SIZE_CHECK = "6개의 숫자를 입력하세요";

    private List<Integer> lottoRange;
    private InputView inputView;
    private ResultView resultView;
    private TotalLotto totalLotto;
    private Price price;

    public Lotto() {
        init();
    }

    public Lotto(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
        init();
    }

    private void init() {
        lottoRange = new ArrayList<>();
        setLottoRange(lottoRange);
    }

    private void setLottoRange(List<Integer> lottoRange) {
        for (int number = MIN_NUMBER; number <= MAX_NUMBER; number++) {
            lottoRange.add(number);
        }
    }

    public LottoNumbers pickLottoOne() {
        Collections.shuffle(lottoRange);
        LottoNumbers lottoNumbers = new LottoNumbers();
        for (int index = 0; index < 6; index++) {
            lottoNumbers.addNumber(new LottoNumber(lottoRange.get(index)));
        }
        return lottoNumbers;
    }

    public TotalLotto pickLottoWithPrice(Price price) {
        TotalLotto totalLotto = new TotalLotto();
        int totalCount = price.getBuyCount();
        for (int index = 0; index < totalCount; index++) {
            totalLotto.addLottoOne(pickLottoOne());
        }
        return totalLotto;
    }

    public void start() {
        buy();
        resultView.showEmptyLine();
        statistics();

    }

    private void buy() {
        try {
            resultView.showInputPrice();
            price = new Price(getPrice());
            totalLotto = pickLottoWithPrice(price);
            showLotto();
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

    private int getPrice() {
        String price = inputView.getPrice();
        validation(price);
        return Integer.parseInt(price);

    }

    private void validation(String number) {
        if (!Pattern.matches("^[0-9]+$", number)) {
            throw new IllegalArgumentException(ONLY_NUMBER);
        }
    }

    private void showCount() {
        resultView.buyCount(totalLotto.size());
    }

    public void statistics() {
        try {
            resultView.showInputVictoryNumber();
            LottoNumbers victoryNumber = getVictoryNumbers(
                inputView.getVictoryNumbers());
            showWinning(totalLotto.getWinningWithNumbers(victoryNumber));
            showBanefit(totalLotto.getBenefit(victoryNumber, price));

        } catch (Exception e) {
            resultView.showText(e.getMessage());
            statistics();
        }

    }

    private void showBanefit(String benefit) {
        resultView.showBenefit(benefit);
    }

    private void showWinning(List<Integer> winningWithNumbers) {
        resultView.showWinning(winningWithNumbers);
    }

    private LottoNumbers getVictoryNumbers(String victoryNumbers) {
        LottoNumbers result = new LottoNumbers();
        String[] numbers = victoryNumbers.split(",");
        for (String number : numbers) {
            number = number.trim();
            validation(number);
            result.addNumber(new LottoNumber(Integer.parseInt(number)));
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
