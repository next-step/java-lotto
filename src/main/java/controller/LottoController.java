package controller;

import domain.*;
import util.LottoValidator;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {
    private final int ZERO = 0;
    private final int LOTTO_UNIT_PRICE = 1000;
    private final int LOTTO_START_NUMBER = 1;
    private final int LOTTO_END_NUMBER = 45;
    private final int LOTTO_RANGE = 6;

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

        List<Integer> basicLottoNumbers = createBasicLottoNumbers();
        Lottos lottos = initLottos(lottoQuantity, basicLottoNumbers);
        resultView.displayLottos(lottos);

        String inputWinningNumber = inputView.inputLastWinningNumber();
        LottoValidator.checkWinningNumberValidate(inputWinningNumber);
        LottoNumbers winningNumbers = new LottoNumbers()
                .createWinningNumbers(inputWinningNumber);

        resultView.displayResultMention();

        Map<Integer, Integer> lottoStatistics = lottos.compileLottoStatistics(winningNumbers);
        resultView.displayStatistic(lottoStatistics);

        double profit = LottoProfit.calculateProfit(lottoStatistics, priceTotal).getProfit();
        resultView.displayProfit(profit);
    }

    public Lottos initLottos(int lottoQuantity, List<Integer> basicLottoNumbers) {
        List<Lotto> lottoList = IntStream
                .range(ZERO, lottoQuantity)
                .mapToObj(quantity -> Lotto.createLotto(shuffleNumbers(basicLottoNumbers)))
                .collect(Collectors.toList());
        return Lottos.from(lottoList);
    }

    public int getLottoQuantity() {
        return lottoInfo.getPrice() / LOTTO_UNIT_PRICE;
    }

    public List<Integer> createBasicLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for(int number = LOTTO_START_NUMBER; number <= LOTTO_END_NUMBER; number++) {
            numbers.add(number);
        }
        return numbers;
    }

    public LottoNumbers shuffleNumbers(List<Integer> basicLottoNumbers) {
        Collections.shuffle(basicLottoNumbers);
        List<Integer> newNumbers = IntStream
                .range(ZERO, LOTTO_RANGE)
                .mapToObj(basicLottoNumbers::get)
                .collect(Collectors.toList());
        return new LottoNumbers().from(newNumbers);
    }
}
