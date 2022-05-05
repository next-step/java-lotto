package Lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private List<Integer> numbers = new ArrayList<>();

    public Lotto(List<Integer> numbers) {
        for (int n : numbers) {
            this.numbers.add(n);
        }
    }

    public int checkWinningLottoNumbers(WinningLottoNumbers winningNumbers) {
        return winningNumbers.checkWinningLottoNumbers(numbers);
    }

    public int getLottoNumber(int idx) {
        return numbers.get(idx);
    }
}
