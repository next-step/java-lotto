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

    public LottoMachine(
            List<Integer> winningNumbers,
            int totalPrice,
            List<List<Integer>> lottoNumbers
    ) {
        checkWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
        this.totalPrice = totalPrice;
        this.lottoNumbers = lottoNumbers;
        this.lottos = this.lottoNumbers.stream()
                .map(Lotto::new)
                .peek(it -> it.calPrize(this.winningNumbers))
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
        List<Prize> prizes = getPrizes(this.lottos);
        return new LottoStatistics(prizes, this.totalPrice);
    }

    private List<Prize> getPrizes(List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::getPrize)
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(Prize::getMatched))
                .collect(Collectors.toList());
    }
}
