package controller;

import domain.*;
import view.InputView;
import view.ResultView;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static domain.LottoStandard.MATCH_BEGINNING;
import static domain.LottoStandard.MATCH_ENDING;

public class LottoController {
    private final int ZERO = 0;
    private final int ONE = 1;
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
        checkUnitPrice(priceTotal, LOTTO_UNIT_PRICE);
        lottoInfo = LottoInfo.from(priceTotal);

        int lottoQuantity = getLottoQuantity();

        int manualQuantity = inputView.inputManualLottoQuantity();
        int autoQuantity = calculateAutoQuantity(lottoQuantity, manualQuantity);

        inputView.inputManualMention();
        checkManualQuantity(lottoQuantity, manualQuantity);

        Lottos manualLottos = inputManualNumbers(inputView, manualQuantity);
        resultView.displayLottoQuantity(manualQuantity, autoQuantity);

        List<Integer> basicLottoNumbers = createBasicLottoNumbers();
        Lottos autoLottos = initLottos(autoQuantity, basicLottoNumbers);
        resultView.displayLottos(autoLottos);

        Lottos lottos = Lottos.combineLottos(manualLottos, autoLottos);

        String[] inputWinningNumber = inputView.inputLastWinningNumber();
        checkLottoNumberValidate(inputWinningNumber);
        LottoNumbers winningNumbers = new LottoNumbers()
                .createLottoNumbers(inputWinningNumber);

        int bonusNumber = inputView.inputBonusNumber();
        checkLottoRange(bonusNumber);
        checkBonusDuplicate(inputWinningNumber, bonusNumber);

        resultView.displayResultMention();

        Map<Integer, Integer> lottoStatistics = lottos.compileLottoStatistics(winningNumbers, bonusNumber);

        displayResult(resultView, lottoStatistics);

        double profit = LottoProfit.calculateProfit(lottoStatistics, priceTotal).getProfit();
        resultView.displayProfit(profit);
    }

    public Lottos inputManualNumbers(InputView inputView, int manualQuantity) {
        List<Lotto> lottos = IntStream.range(ZERO, manualQuantity)
                .mapToObj(i -> {
                    String[] manualNumber = inputView.inputManualNumber();
                    checkLottoNumberValidate(manualNumber);
                    return new Lotto(new LottoNumbers().createLottoNumbers(manualNumber));
                })
                .collect(Collectors.toList());
        return Lottos.from(lottos);
    }

    public int calculateAutoQuantity(int lottoQuantity, int manualQuantity) {
        return lottoQuantity - manualQuantity;
    }

    private void displayResult(ResultView resultView, Map<Integer, Integer> lottoStatistics) {
        int matchBeginning = MATCH_BEGINNING.getStandardNumber();
        int matchEnding = MATCH_ENDING.getStandardNumber();
        for(int key = matchEnding - ONE; key >= matchBeginning; key--) {
            checkPrizeSecond(key, resultView, lottoStatistics);
            checkPrizeExceptSecond(key, resultView, lottoStatistics);
        }
    }

    private void checkPrizeExceptSecond(int key, ResultView resultView, Map<Integer, Integer> lottoStatistics) {
        if(key != LottoPrize.SECOND.getPrize()) {
            resultView.displayPrizeExceptSecond(LottoPrize.valueOf(key).get(ZERO),
                    LottoPrize.valueOf(key).get(ONE),
                    lottoStatistics.get(key));
        }
    }

    private void checkPrizeSecond(int key, ResultView resultView, Map<Integer, Integer> lottoStatistics) {
        if(key == LottoPrize.SECOND.getPrize()) {
            resultView.displaySecondPrize(LottoPrize.valueOf(key).get(ZERO),
                                LottoPrize.valueOf(key).get(ONE),
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
        return IntStream
                .rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    public LottoNumbers shuffleNumbers(List<Integer> basicLottoNumbers) {
        Collections.shuffle(basicLottoNumbers);
        List<Integer> newNumbers = IntStream
                .range(ZERO, LOTTO_RANGE)
                .mapToObj(basicLottoNumbers::get)
                .collect(Collectors.toList());
        return new LottoNumbers().from(newNumbers);
    }

    public void checkLottoNumberValidate(String[] winningNumbers) {
        checkEmptyString(winningNumbers);
        checkNumberLength(winningNumbers);
        Arrays.stream(winningNumbers)
                .map(Integer::new)
                .forEach(this::checkLottoRange);
    }

    private void checkEmptyString(String[] winningNumbers) {
        if(winningNumbers.length < LOTTO_START_NUMBER) {
            throw new IllegalArgumentException("빈 값을 입력할 수 없습니다.");
        }
    }

    private void checkNumberLength(String[] splitNumber) {
        if(splitNumber.length != LOTTO_RANGE) {
            throw new IllegalArgumentException("로또 숫자는 6개입니다.");
        }
    }

    public void checkLottoRange(int number) {
        if(number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException("로또 범위는 1 ~ 45 입니다.");
        }
    }

    public void checkUnitPrice(int priceTotal, int unitPrice) {
        if(priceTotal < unitPrice || priceTotal % unitPrice != ZERO) {
            throw new IllegalArgumentException("로또 금액 단위로 구매 가능합니다.");
        }
    }

    public void checkBonusDuplicate(String[] winningNumbers, int bonusNumber) {
        for(String number : winningNumbers) {
            matchBonus(number, bonusNumber);
        }
    }

    private void matchBonus(String number, int bonusNumber) {
        if(Integer.parseInt(number) == bonusNumber) {
            throw new IllegalArgumentException("보너스 번호가 정답로또와 중복됩니다.");
        }
    }

    public void checkManualQuantity(int lottoQuantity, int manualQuantity) {
        if(lottoQuantity < manualQuantity) {
            throw new IllegalArgumentException("로또 금액보다 큰 개수입니다.");
        }
    }
}
