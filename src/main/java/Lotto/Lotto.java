package Lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    List<Integer> numbers = new ArrayList<>();

    public Lotto(int[] numbers) {
        for (int n : numbers) {
            this.numbers.add(n);
        }
    }

    public int checkLottoNumbers(int[] lottoAnswers) {
        int cnt = 0;
        for (int ans : lottoAnswers) {
            for (int n : numbers) {
                if(ans == n) {
                    cnt += 1;
                }
            }
        }

        return cnt;
    }
}
