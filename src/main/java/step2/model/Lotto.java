package step2.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> inputNumber) {
        lottoNumbers = inputNumber;
    }

    public List<Integer> getLottonumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public int checkWinningCount(List<Integer> winningNumbers) {
        int cnt = 0;
        for (Integer number : winningNumbers) {
            if (lottoNumbers.contains(number)) {
                cnt++;
            }
        }
        return cnt;
    }
}
