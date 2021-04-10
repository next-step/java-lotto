package lotto.domain;

import lotto.common.LottoConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private final List<LottoNumber> lottoNumber;

    public LottoMachine() {
        List<Integer> integers = initLottoRange();
        this.lottoNumber = integers.stream()
                            .map(LottoNumber::lottoNumber)
                            .collect(Collectors.toList());
    }

    private List<Integer> initLottoRange() {
        return IntStream.rangeClosed(LottoConstants.MIN_LOTTO_NUMBER, LottoConstants.MAX_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    public int buyCount(int money) {
        return money / LottoConstants.LOTTO_PRICE;
    }

    public List<LottoNumbers> lottoNumbers(int buyCount){

        List<LottoNumbers> buyLotto = new ArrayList<>();

        for (int i = 0; i < buyCount; i++) {
            buyLotto.add(oneLottoNumbers());
        }

        return buyLotto;
    }

    private LottoNumbers oneLottoNumbers() {

        Collections.shuffle(lottoNumber);

        return lottoNumber.stream()
                .limit(LottoConstants.LOTTO_NUMBER_COUNT)
                .sorted(Comparator.comparing(LottoNumber::getNumber))
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoNumbers::new));

    }

    public boolean useAbleBonusBall(String winningNumbers, int bonusBall) {
        return !winningNumbers.contains(Integer.toString(bonusBall));
    }
}
