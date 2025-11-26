package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoChecker;
import lotto.domain.LottoGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        long price = InputView.initLottoPrice();
        LottoGenerator lottoGenerator = new LottoGenerator(price);
        ResultView.printLottos(lottoGenerator.getLottos());

        LottoChecker lottoChecker = new LottoChecker();
        String[] split = InputView.initWinningLotto().split(",");

        Map<Integer, Integer> result =
                lottoChecker.check(lottoGenerator.getLottos(), new Lotto(Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList())));

        ResultView.printResult(result);

    }
}
