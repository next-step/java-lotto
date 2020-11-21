package controller;

import domain.*;
import view.InputView;
import view.ResultView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {
    private final int ZERO = 0;
    private final int FIRST_COUNT = 1;
    private final int PRIZE_BEGINNING = 3;
    private final int PRIZE_ENDING = 7;
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

        Map<Integer, Integer> lottoStatistics = compileLottoStatistics(winningNumbers, lottos);
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

    public int matchLottoNumbers(LottoNumbers winningLotto, Lotto lotto) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        List<Integer> lottoNumbers = lotto.getLottoNumbers().getNumbers();

        return (int) lottoNumbers
                .stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public Map<Integer, Integer> compileLottoStatistics(LottoNumbers winningLotto, Lottos lottos) {
        List<Integer> matches = lottos.getLottos()
                .stream()
                .map(lotto -> matchLottoNumbers(winningLotto, lotto))
                .filter(match -> match >= PRIZE_BEGINNING)
                .collect(Collectors.toList());

        Map<Integer, Integer> matchMap = new HashMap<>();
        matches.forEach(match -> matchMap.merge(match, FIRST_COUNT, Integer::sum));

        IntStream.range(PRIZE_BEGINNING, PRIZE_ENDING)
                .filter(key -> !matchMap.containsKey(key))
                .forEach(key -> matchMap.put(key, ZERO));

        return matchMap;
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
