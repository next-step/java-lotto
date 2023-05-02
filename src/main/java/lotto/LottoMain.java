package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Scanner;

public class LottoMain {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        ResultView resultView = new ResultView();
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

        int lottoCount = inputView.price();

        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(lottoNumberGenerator.lotto());
            resultView.view(lotto.lottoNumbers());
        }

        inputView.result();
    }
}
