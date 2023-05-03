package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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

        List<LottoNumber> winNumber = inputView.result();

        List<LottoMatcher> collect = lottos.stream()
                .map(lotto -> lotto.match(winNumber))
                .collect(Collectors.toList());

        LottoResult lottoResult = new LottoResult(collect);
        lottoResult.result();
    }
}
