package lotto.domain;

import java.util.List;

public class Lotto {

    public static final int LOTTO_PRICE = 1_000;
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static int findPurchaseCount(int purchaseAmount) {
        return (int) purchaseAmount / LOTTO_PRICE;
    }

    public int getMatchNumbers(List<Integer> winningNumbers, Lotto lotto) {
        return (int) lotto.getLottoNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
