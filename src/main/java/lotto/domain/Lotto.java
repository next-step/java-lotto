package lotto.domain;

import java.util.List;

public class Lotto {
    private static final int LOTTO_PRICE = 1000;

    private final List<Integer> lottoNumbers;

    public Lotto() {
        this.lottoNumbers = LottoNumbers.shuffleLottoNumbers();
    }

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static int calculateLottoCount(int totalAmount) {
        return totalAmount / LOTTO_PRICE;
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public int confirmWinning(List<Integer> winningNumbers) {
        return (int) this.lottoNumbers.stream().filter(winningNumbers::contains).count();
    }
}
