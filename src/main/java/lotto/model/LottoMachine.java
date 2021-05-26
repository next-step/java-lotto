package lotto.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.common.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.common.LottoConstants.MIN_LOTTO_NUMBER;
import static lotto.common.LottoConstants.LOTTO_NUMBER_COUNT;
import static lotto.view.InputView.LOTTO_PRICE;

public class LottoMachine {

    private final List<LottoNumber> lottoNumber;

    public LottoMachine() {
        List<Integer> integers = initLottoRange();
        this.lottoNumber = integers.stream()
                .map(LottoNumber::lottoNumber)
                .collect(Collectors.toList());
    }

    private List<Integer> initLottoRange() {
        return IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<LottoNumbers> autoLottoNumbers(int buyCount) {
        return IntStream.range(0, buyCount).mapToObj(i -> oneLottoNumbers()).collect(Collectors.toList());
    }

    public int buyCount(int money) {
        return money / LOTTO_PRICE;
    }

    private LottoNumbers oneLottoNumbers() {

        Collections.shuffle(lottoNumber);

        return lottoNumber.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .sorted(Comparator.comparing(LottoNumber::number))
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoNumbers::new));

    }
}
