package lotto.model;

import java.util.List;

public class Lotto {
    private static final int NUMBER_OF_LOTTO_NUMBERS = 6;
    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int countWinningNumbers(Lotto winningNumbers) {
        int count = 0;
        for (int i = 0; i < NUMBER_OF_LOTTO_NUMBERS; i++) {
            if (lottoNumbers.contains(winningNumbers.getNumbers().get(i))) {
                count++;
            }
        }
        return count;
    }

    public boolean contains(int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return lottoNumbers;
    }
}
