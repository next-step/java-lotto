package step2.controller;

import step2.domain.Lotto;
import step2.domain.LottoNumber;
import step2.domain.Lottos;
import step2.domain.Money;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    private static ResultView resultView = new ResultView();

    public static void operate(InputView inputView) {
        Money money = new Money(inputView.getMoney());
        Lottos lottos = LottoMachine.createLottos(money);
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

    public static Lotto createLotto(Integer ... inputNumbers) {
        List<Integer> numbers = Arrays.asList(inputNumbers);
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for(int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
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
}
