package study.lotto;

import study.lotto.model.Lotto;
import study.lotto.model.LottoList;
import study.lotto.model.LottoNumber;
import study.lotto.model.Statistics;
import study.lotto.view.InputView;
import study.lotto.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;

    public void play() {
        int totalPrice = InputView.scanTotalPrice();
        int numOfLotto = totalPrice / LOTTO_PRICE;

        LottoList lottoList = LottoList.create(numOfLotto);

        System.out.println(numOfLotto + "개를 구매했습니다.");

        ResultView.printLottoList(lottoList);
        ResultView.printEmptyLine();

        Lotto winningLotto = convertToLotto(InputView.scanWinningNumbers());

        Statistics statistics = Statistics.createStatistics(totalPrice, lottoList, winningLotto);

        ResultView.printEmptyLine();
        ResultView.printStatistics(statistics);
    }

    private Lotto convertToLotto(String[] winningNumbers) {
        List<LottoNumber> winningNumberList = Arrays.stream(winningNumbers)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        return new Lotto(winningNumberList);
    }

    public static void main(String[] args) {
        new LottoGame().play();
    }
}
