package lotto;

import java.util.List;

public class Lotto {
    private static final int AVAILABLE_MIN_NUMBER = 1;
    private static final int AVAILABLE_MAX_NUMBER = 45;
    private static final int MIN_LENGTH = 0;
    private static final int MAX_LENGTH = 6;
    private static final AvailableNumbers availableNumbers = new AvailableNumbers(AVAILABLE_MIN_NUMBER, AVAILABLE_MAX_NUMBER);

    private final LottoNumbers lottoNumbers;

    public Lotto() {
        availableNumbers.shuffle();
        lottoNumbers = new LottoNumbers(availableNumbers.subList(MIN_LENGTH, MAX_LENGTH));
    }

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

    public boolean checkBonusBallNumber(int bonusNumber) {
        return this.lottoNumbers.contains(bonusNumber);
    }

    public int findMatchedNumberCount(WinningLottoNumbers winningLottoNumbers) {
        return winningLottoNumbers.match(this.lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

}
