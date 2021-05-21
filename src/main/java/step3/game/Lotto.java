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
    private List<Integer> lottoRange;
    private InputView inputView;
    private ResultView resultView;

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

    public void buy() {
        try {
            resultView.showInputPrice();
            int price = getPrice();
            TotalLotto totalLotto = pickLottoWithPrice(new Price(price));
            showLotto(totalLotto);
        } catch (Exception e) {
            resultView.showText(e.getMessage());
            buy();
        }
    }

    private void showLotto(TotalLotto totalLotto) {
        showCount(totalLotto);
        showTotalLotto(totalLotto);
    }

    private void showTotalLotto(TotalLotto totalLotto) {
        resultView.showTotalLotto(totalLotto.lotto());
    }

    private int getPrice() {
        String price = inputView.getPrice();
        validation(price);
        return Integer.parseInt(price);

    }

    private void validation(String price) {
        if (!Pattern.matches("^[0-9]+$", price)) {
            throw new IllegalArgumentException(ONLY_NUMBER);
        }
    }

    private void showCount(TotalLotto totalLotto) {
        resultView.buyCount(totalLotto.size());
    }
}
