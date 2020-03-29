package step2.controller;

import step2.domain.*;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.*;
import java.util.stream.Collectors;

public class LottoMachine {
    private static ResultView resultView = new ResultView();

    public static void operate(InputView inputView) {
        Money money = new Money(inputView.getMoney());
        Lottos lottos = LottoMachine.createLottos(money);
        Lotto winningLotto = LottoMachine.createLotto(inputView.getWinningNumbers());

        resultView.printResult(makeLottoResult(winningLotto, lottos), money);
    }

    public static Lottos createLottos(Money money) {
        List<Lotto> createdLottos = new ArrayList<Lotto>();
        int lottoCount = money.getLottoCount();

        for(int i = 0; i < lottoCount; i++) {
            createdLottos.add(createLotto());
        }
        Lottos lottos = new Lottos(createdLottos);
        resultView.showLottos(lottos, lottoCount);

        return lottos;
    }

    private static Lotto createLotto() {
        List<LottoNumber> lotto = getShuffledNumber()
                .stream()
                .limit(Lotto.COUNT_NUMBER)
                .sorted()
                .collect(Collectors.toList());

        return new Lotto(lotto);
    }

    public static Lotto createLotto(List<Integer> inputNumbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for(int number : inputNumbers) {
            lottoNumbers.add(new LottoNumber(number)); // TODO: 같은 값(getValue)으로 만들어진 LottoNumber 객체가 있으면 새로 안만들게 하고 싶다.
        }
        return new Lotto(lottoNumbers);
    }

    private static List<LottoNumber> getShuffledNumber() {
        List<LottoNumber> shuffledNumber = getWholeNumber();
        Collections.shuffle(shuffledNumber);

        return shuffledNumber;
    }

    private static List<LottoNumber> getWholeNumber() {
        List<LottoNumber> numbers = new ArrayList<>();

        for(int i = LottoNumber.MIN_NUMBER; i <= LottoNumber.MAX_NUMBER; i++) {
            numbers.add(new LottoNumber(i));
        }
        return numbers;
    }

    public static LottoResult makeLottoResult(Lotto winningLotto, Lottos lottos) {
        Map<LottoTier, Integer> resultMap = new HashMap<>();

        for(LottoTier lottoTier : LottoTier.values()) {
            resultMap.put(lottoTier, getLottoCountByTier(lottoTier, lottos, winningLotto));
        }
        return new LottoResult(resultMap);
    }

    private static int getLottoCountByTier(LottoTier lottoTier, Lottos lottos, Lotto winningLotto) {
        int count = 0;

        for(Lotto lotto : lottos.getValue()) {
            count = addIfSameTier(lotto, count, winningLotto, lottoTier);
        }
        return count;
    }

    private static int addIfSameTier(Lotto lotto, int count, Lotto winningLotto, LottoTier lottoTier) {
        if(lottoTier.equals(lotto.getLottoTier(winningLotto))) {
            count++;
        }
        return count;
    }
}
