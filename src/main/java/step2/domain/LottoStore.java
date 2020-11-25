package step2.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoStore {

    private List<Lotto> soldLotto;
    private List<Integer> winNumbers;
    private List<Long> winLottoMoney;

    public List<Lotto> buy(int fee) {
        if (isEnougisNotEnoughFeehFee(fee)){
            throw new IllegalArgumentException("금액이 충분하지 않습니다.");
        }

        int buyCount = getBuyCount(fee);

        this.soldLotto = new ArrayList<>();
        for (int count = 0; count < buyCount; count++) {
            this.soldLotto.add(new Lotto());
        }

        return soldLotto;
    }

    private int getBuyCount(int fee) {
        return fee/1000;
    }

    private boolean isEnougisNotEnoughFeehFee(int fee) {
        return fee < 1000;
    }

    public void initWinNumbers(String winNumberString) {
        stringFormatValid(winNumberString);
        stringToInt(split(winNumberString));
        numberValid();

    }

    private void numberValid() {
        Optional<Integer> isNotLottoNumber = this.winNumbers.stream().filter(number -> isNotLottoNumber(number)).findAny();
        if (isNotLottoNumber.isPresent()) {
            throw new IllegalArgumentException("잘못된 당첨번호를 입력하였습니다.");
        }
    }

    private void stringToInt(String[] split) {
        this.winNumbers =  Arrays.stream(split).map(m -> parseInt(m))
                .collect(Collectors.toList());
    }

    private String[] split(String winNumberString) {
        return winNumberString.split(",");
    }

    private boolean isNotLottoNumber(int number) {
        return number < 1 || number > 45;
    }

    private int parseInt(String numberString) {
        try {
            return Integer.parseInt(numberString);
        } catch (Exception e) {
            throw new RuntimeException("숫자가 입력되지 않았습니다.");
        }
    }

    private void stringFormatValid(String winNumberString) {
        if (isBlank(winNumberString)) {
            throw new IllegalArgumentException("잘못된 당첨번호를 입력했습니다.");
        }

        if (isNotMatchNumberCount(winNumberString)) {
            throw new IllegalArgumentException("6개의 숫자를 입력하세요.");
        }
    }

    private boolean isNotMatchNumberCount(String winNumberString) {
        String[] split = winNumberString.split(",");
        return split.length != 6;
    }

    private boolean isBlank(String winNumberString) {
        return Objects.isNull(winNumberString) || winNumberString.trim().isEmpty();
    }

    public List<Integer> getWinNumbers() {
        return this.winNumbers;
    }

    public List<Long> findWinLottoMoney() {
        this.winLottoMoney = new ArrayList<>();
        for (Lotto lotto : this.soldLotto) {
            findMoney(findIsMatchNumberCount(lotto));
        }
        return this.winLottoMoney;
    }

    private void findMoney(long winNumberCount) {
        Optional<LottoRank> rank = LottoRank.findRank(winNumberCount);
        if (!rank.isPresent()) {
            return;
        }

        this.winLottoMoney.add(rank.get().findMoney());
    }

    private long findIsMatchNumberCount(Lotto lotto) {
        return this.winNumbers.stream()
                .filter(winNumber -> lotto.getNumbers().contains(winNumber))
                .count();
    }
}
