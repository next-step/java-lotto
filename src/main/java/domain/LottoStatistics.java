package domain;

import java.util.List;

public class LottoStatistics {

    private List<Integer> winningNumbers;

    public LottoStatistics(String values) {
        winningNumbers = new Lotto(values).getLottoNumbers();
    }

    public List<Integer> getNumbers(String numbers) {
        return new Lotto(numbers).getLottoNumbers();
    }

    public Jackpot getJackpot(List<Integer> lottoNumbers) {
        int sameCount = 0;
        for (int number: lottoNumbers) {
            if(hasNumber(number)) {
                sameCount += 1;
            }
        }
        return Jackpot.valueOf(sameCount);
    }

    private boolean hasNumber(Integer number) {
        return winningNumbers.contains(number);
    }
}
