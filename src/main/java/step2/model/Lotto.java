package step2.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private List<Integer> LottoNumbers;

    public Lotto(List<Integer> inputNumber) {
        LottoNumbers = inputNumber;
    }

    public List<Integer> getLottonumbers() {
        return Collections.unmodifiableList(LottoNumbers);
    }

    public int checkWinningCount(List<Integer> winningNumbers) {
        int cnt = 0;
        for (Integer number : winningNumbers) {
            if (LottoNumbers.contains(number)) {
                cnt++;
            }
        }
        return cnt;
    }
}
