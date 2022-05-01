package Lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private List<Integer> numbers = new ArrayList<>();

    public Lotto(int[] numbers) {
        for (int n : numbers) {
            this.numbers.add(n);
        }
    }

    public int getLottoNumber(int idx) {
        return numbers.get(idx);
    }

    public int checkWinningLottoNumbers(int[] winningNumbers) {
        int cnt = 0;
        for (int num : winningNumbers) {
            cnt = checkWinningLottoNumbers(cnt, num);
        }

        return cnt;
    }

    private int checkWinningLottoNumbers(int cnt, int answerNum) {
        for (int myLottoNum : numbers) {
            if(myLottoNum == answerNum) {
                cnt += 1;
            }
        }
        return cnt;
    }
}
