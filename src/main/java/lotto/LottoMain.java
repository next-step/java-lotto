package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoMain {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        ResultView resultView = new ResultView();
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

        int lottoCount = inputView.price();

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(lottoNumberGenerator.lotto()));
            resultView.view(lottos);
        }

        List<LottoNumber> result = inputView.result();

        lottos.forEach(lotto -> {
            LottoMatcher result1 = lotto.result(result);
            System.out.println(result1);
        });
    }
}
