package domain;

import java.util.ArrayList;
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

    public List<Jackpot> getJackpots(List<Lotto> lottos) {
        List<Jackpot> jackpots = new ArrayList<>();
        for (Lotto lotto : lottos) {
            Jackpot jackpot = getJackpot(lotto.getLottoNumbers());
            jackpots.add(jackpot);
        }
        return jackpots;
    }

    private boolean hasNumber(Integer number) {
        return winningNumbers.contains(number);
    }
}
