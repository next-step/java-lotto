package lotto.domain;

import lotto.common.LottoConstants;

import java.util.*;
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

    public List<LottoNumbers> autoLottoNumbers(int buyCount) {
        return IntStream.range(0, buyCount).mapToObj(i -> oneLottoNumbers()).collect(Collectors.toList());
    }

    private LottoNumbers oneLottoNumbers() {

        Collections.shuffle(lottoNumber);

        return lottoNumber.stream()
                .limit(LottoConstants.LOTTO_NUMBER_COUNT)
                .sorted(Comparator.comparing(LottoNumber::getNumber))
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoNumbers::new));

    }

    public boolean useAbleBonusBall(String winningNumbers, int bonusBall) {
        return Arrays.stream(winningNumbers.split(","))
                .noneMatch(winningNumber -> winningNumber.equals(Integer.toString(bonusBall)));
    }

    public List<LottoNumbers> manualLottoNumbers(List<String> manualBuys) {
        return manualBuys.stream().map(LottoNumbers::new).collect(Collectors.toList());
    }

    public void buyCountValid(int buyCount, int manualBuyCount) {
        if (manualBuyCount > buyCount) {
            throw new IllegalArgumentException("수동 구매 개수가 총 구매 개수 보다 클 수 없습니다.");
        }
    }

    public List<LottoNumbers> getLottoNumbers(List<String> manualLotto, int autoBuyCount) {
        List<LottoNumbers> manualLottoNumbers = manualLottoNumbers(manualLotto);
        List<LottoNumbers> autoLottoNumbers = autoLottoNumbers(autoBuyCount);
        List<LottoNumbers> lottoNumbers = new ArrayList<>();

        lottoNumbers.addAll(manualLottoNumbers);
        lottoNumbers.addAll(autoLottoNumbers);

        return lottoNumbers;
    }
}
