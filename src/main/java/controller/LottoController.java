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

import static domain.LottoStandard.MATCH_BEGINNING;
import static domain.LottoStandard.MATCH_ENDING;

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
        LottoValidator.checkUnitPrice(priceTotal, LOTTO_UNIT_PRICE);
        lottoInfo = LottoInfo.from(priceTotal);

        int lottoQuantity = getLottoQuantity();

        int manualQuantity = inputView.inputManualLottoQuantity();
        int autoQuantity = calculateAutoQuantity(lottoQuantity, manualQuantity);

        inputView.inputManualMention();
        List<String> manualNumbers = inputManualNumbers(inputView, manualQuantity);

        resultView.displayLottoQuantity(manualQuantity, autoQuantity);

        List<Integer> basicLottoNumbers = createBasicLottoNumbers();
        Lottos lottos = initLottos(lottoQuantity, basicLottoNumbers);
        resultView.displayLottos(lottos);

        String inputWinningNumber = inputView.inputLastWinningNumber();
        LottoValidator.checkWinningNumberValidate(inputWinningNumber);
        LottoNumbers winningNumbers = new LottoNumbers()
                .createWinningNumbers(inputWinningNumber);

        int bonusNumber = inputView.inputBonusNumber();
        LottoValidator.checkLottoRange(bonusNumber);
        LottoValidator.checkBonusDuplicate(inputWinningNumber, bonusNumber);

        resultView.displayResultMention();

        Map<Integer, Integer> lottoStatistics = lottos.compileLottoStatistics(winningNumbers, bonusNumber);

        displayResult(resultView, lottoStatistics);

        double profit = LottoProfit.calculateProfit(lottoStatistics, priceTotal).getProfit();
        resultView.displayProfit(profit);
    }

    public List<String> inputManualNumbers(InputView inputView, int manualQuantity) {
        return IntStream.range(ZERO, manualQuantity)
                .mapToObj(i -> {
                    String manualNumber = inputView.inputManualNumber();
                    LottoValidator.checkManualDuplicate(manualNumber);
                    return manualNumber;
                })
                .collect(Collectors.toList());
    }

    public int calculateAutoQuantity(int lottoQuantity, int manualQuantity) {
        return lottoQuantity - manualQuantity;
    }

    private void displayResult(ResultView resultView, Map<Integer, Integer> lottoStatistics) {
        int matchBeginning = MATCH_BEGINNING.getStandardNumber();
        int matchEnding = MATCH_ENDING.getStandardNumber();
        for(int key = matchEnding - 1; key >= matchBeginning; key--) {
            checkPrizeSecond(key, resultView, lottoStatistics);
            checkPrizeExceptSecond(key, resultView, lottoStatistics);
        }
    }

    private void checkPrizeExceptSecond(int key, ResultView resultView, Map<Integer, Integer> lottoStatistics) {
        if(key != LottoPrize.SECOND.getPrize()) {
            resultView.displayPrizeExceptSecond(LottoPrize.valueOf(key).get(0),
                    LottoPrize.valueOf(key).get(1),
                    lottoStatistics.get(key));
        }
    }

    private void checkPrizeSecond(int key, ResultView resultView, Map<Integer, Integer> lottoStatistics) {
        if(key == LottoPrize.SECOND.getPrize()) {
            resultView.displaySecondPrize(LottoPrize.valueOf(key).get(0),
                                LottoPrize.valueOf(key).get(1),
                                lottoStatistics.get(key));
        }
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
