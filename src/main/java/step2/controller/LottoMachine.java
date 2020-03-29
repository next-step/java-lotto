package step2.controller;

import step2.domain.*;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.*;
import java.util.stream.Collectors;

public class LottoMachine {
    private static ResultView resultView;
    private static LottoMachine lottoMachine;

    private LottoMachine() {
        this.resultView = new ResultView();
    }

    public void operate(InputView inputView) {
        Money money = new Money(inputView.getMoney());
        Lottos lottos = lottoMachine.createLottos(money);
        Lotto winningLotto = lottoMachine.createLotto(inputView.getWinningNumbers());

        resultView.printResult(makeLottoResult(winningLotto, lottos), money);
    }

    public Lottos createLottos(Money money) {
        List<Lotto> createdLottos = new ArrayList<>();
        int lottoCount = money.getLottoCount();

        for(int i = 0; i < lottoCount; i++) {
            createdLottos.add(createLotto());
        }
        Lottos lottos = new Lottos(createdLottos);
        resultView.showLottos(lottos, lottoCount);

        return lottos;
    }

    private Lotto createLotto() {
        List<LottoNumber> lotto = getShuffledNumber()
                .stream()
                .limit(Lotto.COUNT_NUMBER)
                .sorted()
                .collect(Collectors.toList());

        return new Lotto(lotto);
    }

    public Lotto createLotto(List<Integer> inputNumbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for(int number : inputNumbers) {
            lottoNumbers.add(new LottoNumber(number)); // TODO: 같은 값(getValue)으로 만들어진 LottoNumber 객체가 있으면 새로 안만들게 하고 싶다.
        }
        return new Lotto(lottoNumbers);
    }

    private List<LottoNumber> getShuffledNumber() {
        List<LottoNumber> shuffledNumber = getWholeNumber();
        Collections.shuffle(shuffledNumber);

        return shuffledNumber;
    }

    private List<LottoNumber> getWholeNumber() {
        List<LottoNumber> numbers = new ArrayList<>();

        for(int i = LottoNumber.MIN_NUMBER; i <= LottoNumber.MAX_NUMBER; i++) {
            numbers.add(new LottoNumber(i));
        }
        return numbers;
    }

    public LottoResult makeLottoResult(Lotto winningLotto, Lottos lottos) {
        Map<LottoTier, Integer> resultMap = new HashMap<>();

        for(LottoTier lottoTier : LottoTier.values()) {
            resultMap.put(lottoTier, getLottoCountByTier(lottoTier, lottos, winningLotto));
        }
        return new LottoResult(resultMap);
    }

    private int getLottoCountByTier(LottoTier lottoTier, Lottos lottos, Lotto winningLotto) {
        int count = 0;

        for(Lotto lotto : lottos.getValue()) {
            count = addIfSameTier(lotto.getLottoTier(winningLotto), lottoTier, count);
        }
        return count;
    }

    private int addIfSameTier(LottoTier resultTier, LottoTier lottoTier, int count) {
        if(lottoTier.equals(resultTier)) {
            count++;
        }
        return count;
    }

    public static LottoMachine getInstance() {
        if(lottoMachine == null) {
            lottoMachine = new LottoMachine();
        }
        return lottoMachine;
    }
}
