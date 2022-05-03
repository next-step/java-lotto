package Lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private List<Integer> numbers = new ArrayList<>();

    public Lotto(List<Integer> numbers) {
        for (int n : numbers) {
            this.numbers.add(n);
        }
    }

    public int checkWinningLottoNumbers(List<Integer> winningNumbers) {
        int cnt = 0;
        for (int num : winningNumbers) {
            cnt = checkWinningLottoNumbers(cnt, num);
        }

        return cnt;
    }

    private int checkWinningLottoNumbers(int cnt, int answerNum) {
        if (numbers.contains(answerNum)) {
            cnt += 1;
        }

        return cnt;
    }

    public int getLottoNumber(int idx) {
        return numbers.get(idx);
    }
}
