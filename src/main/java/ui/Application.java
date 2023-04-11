package ui;

import lotto.Lotto;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Lotto lotto = null;

        inputView.saveAmount();
        inputView.saveCount();

        lotto = new Lotto(inputView.count);

        Map<Integer, List<Integer>> lottoNumbers = lotto.getLottoNumbers();

        for (int i = 0; i < lottoNumbers.size(); i++) {
            System.out.println(lottoNumbers.get(i));
        }
    }
}
