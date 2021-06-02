package lotto.model;

import lotto.exception.BuyCountErrorException;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.common.LottoConstants.*;

public class LottoMachine {
    private static final int ZERO = 0;
    private final List<LottoNumber> lottoNumber;

    public LottoMachine() {
        List<Integer> integers = initLottoRange();
        this.lottoNumber = integers.stream()
                .map(LottoNumber::valueOf)
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

    public boolean validateMoney(int money) {
        if (money <= ZERO) {
            return false;
        }
        return money % LOTTO_PRICE == ZERO;
    }

    private LottoNumbers oneLottoNumbers() {

        Collections.shuffle(lottoNumber);

        return lottoNumber.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .sorted(Comparator.comparing(LottoNumber::number))
                .collect(Collectors.collectingAndThen(Collectors.toSet(), LottoNumbers::new));

    }

    public boolean useAbleBonusBall(String numbers, LottoNumber bonusBall) {
        return Arrays.stream(numbers.split(","))
                .noneMatch(bonusBall::isSameNumber);
    }

    public void buyCountValid(int buyCount, int manualBuyCount) {
        if (manualBuyCount > buyCount) {
            throw new BuyCountErrorException();
        }
    }
}
