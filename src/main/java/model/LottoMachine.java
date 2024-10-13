package model;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
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
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("Bonus number must be between 1 and 45");
        }
        boolean match = this.winningNumbers.stream()
                .anyMatch(it -> it.equals(bonusNumber));
        if (match) {
            throw new IllegalArgumentException("Bonus number " + bonusNumber + " is wrong.");
        }
    }

    private void setLottos() {
        this.lottos = this.lottoNumbers.stream()
                .map(it -> new Lotto(it, this.winningNumbers, this.bonusNumber))
                .collect(Collectors.toList());
    }

    private static void checkWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("input length must be less than or equal to 6");
        }
        int cnt = (int) winningNumbers.stream()
                .filter(it -> it < Lotto.MIN_LOTTO_NUMBER || it > Lotto.MAX_LOTTO_NUMBER)
                .count();
        if (cnt > 0) {
            throw new IllegalArgumentException("lotto number must be between 1 and 45");
        }
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
