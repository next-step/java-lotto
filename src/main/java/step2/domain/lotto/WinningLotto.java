package step2.domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {
    public final List<Integer> winningNumbers;

    public WinningLotto(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int countMatchedNumbers(List<Integer> lottoNumbers) {
        Set<Integer> winningSet = new HashSet<>(winningNumbers);
        Set<Integer> lottoSet = new HashSet<>(lottoNumbers);
        winningSet.retainAll(lottoSet);
        return winningSet.size();
    }

}
