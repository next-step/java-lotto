package step2.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> inputLottoNumber) {
        lottoNumbers = inputLottoNumber;
    }

    public List<Integer> getLottonumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public int checkWinningCount(List<Integer> winningNumbers) {
        int cnt = 0;
        for (Integer number : winningNumbers) {
            cnt = plusContainNumber(number);
        }
        return cnt;
    }

    public int plusContainNumber(Integer number) {
        if (lottoNumbers.contains(number)) {
            number++;
        }

        return number;
    }
}
