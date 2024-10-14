package model;

import java.util.*;
import java.util.stream.Collectors;

public class LottoMachine {
    public static final int PRICE_OF_A_LOTTO = 1000;

    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private int totalPrice;
    private List<List<Integer>> lottoNumbers;
    private Integer bonusNumber;

    public LottoMachine(
            List<Integer> winningNumbers,
            int totalPrice,
            List<List<Integer>> lottoNumbers
    ) {
        this(winningNumbers, totalPrice, lottoNumbers, null);
    }

    public LottoMachine(
            List<Integer> winningNumbers,
            int totalPrice,
            List<List<Integer>> lottoNumbers,
            Integer bonusNumber
    ) {
        checkWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
        this.totalPrice = totalPrice;
        this.lottoNumbers = lottoNumbers;
        checkBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
        setLottos();
    }

    private void checkBonusNumber(Integer bonusNumber) {
        if (bonusNumber == null) {
            return;
        }
        checkLottoNumberRange(bonusNumber);
        if (doesWinningNumbersContain(bonusNumber)) {
            throw new IllegalArgumentException("Bonus number " + bonusNumber + " is wrong.");
        }
    }

    private boolean doesWinningNumbersContain(Integer bonusNumber) {
        return this.winningNumbers.stream()
                .anyMatch(it -> it.equals(bonusNumber));
    }

    private static void checkLottoNumberRange(Integer number) {
        if (number < Lotto.MIN_LOTTO_NUMBER || number > Lotto.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("Bonus number must be between 1 and 45");
        }
    }

    private static void checkWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("input length must be less than or equal to 6");
        }

        Set<Integer> winningNumbersSet = new HashSet<>(winningNumbers);
        if (winningNumbersSet.size() != winningNumbers.size()) {
            throw new IllegalArgumentException("winning numbers contain duplicate numbers");
        }

        winningNumbers.forEach(LottoMachine::checkLottoNumberRange);
    }

    private void setLottos() {
        this.lottos = this.lottoNumbers.stream()
                .map(it -> new Lotto(it, this.winningNumbers, this.bonusNumber))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getNumberOfLotto() {
        return this.totalPrice / PRICE_OF_A_LOTTO;
    }

    public LottoStatistics getStatistics() {
        return new LottoStatistics(getPrizes(this.lottos), this.totalPrice);
    }

    private List<Prize> getPrizes(List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::getPrize)
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(Prize::getMatched))
                .collect(Collectors.toList());
    }
}
