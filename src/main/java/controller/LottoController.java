package controller;

import domain.*;
import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {
    private final int ZERO = 0;
    private final int LOTTO_UNIT_PRICE = 1000;

    private LottoInfo lottoInfo;

    public LottoController() {
    }

    public LottoController(LottoInfo lottoInfo) {
        this.lottoInfo = lottoInfo;
    }

    public LottoController(int price) {
        lottoInfo = LottoInfo.from(price);
    }

    public void lottoStart() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int priceTotal = inputView.inputPrice();
        lottoInfo = LottoInfo.from(priceTotal);

        int lottoQuantity = getLottoQuantity();
        resultView.displayLottoQuantity(lottoQuantity);

        Lottos lottos = initLottos(lottoQuantity);
        resultView.displayLottos(lottos);

        LottoNumbers winningNumbers = new LottoNumbers()
                .createWinningNumbers(inputView.inputLastWinningNumber());

        resultView.displayResultMention();

        Map<Integer, Integer> lottoStatistics = lottos.compileLottoStatistics(winningNumbers);
        resultView.displayStatistic(lottoStatistics);

        double profit = calculateProfit(lottoStatistics, priceTotal);
        resultView.displayProfit(profit);

    }

    public Lottos initLottos(int lottoQuantity) {
        List<Lotto> lottoList = IntStream
                .range(ZERO, lottoQuantity)
                .mapToObj(quantity -> Lotto.createLotto())
                .collect(Collectors.toList());
        return Lottos.from(lottoList);
    }

    public int getLottoQuantity() {
        return lottoInfo.getPrice() / LOTTO_UNIT_PRICE;
    }

    public double calculateProfit(Map<Integer, Integer> lottoStatistics, int price) {
        int prizeSum = lottoStatistics.keySet()
                .stream()
                .mapToInt(key -> key)
                .map(key -> lottoStatistics.get(key) * LottoPrize.valueOf(key))
                .sum();

        return (double) prizeSum / (double) price;
    }
}
